package com.fortegrp.at.ui.content

import com.fortegrp.at.ui.extension.NonEmptyNavigator
import geb.Module
import geb.navigator.EmptyNavigator

/**
 * Created by yhraychonak on 5/21/2015.
 */

class TableModule extends Module {

    static content = {
        headers { $("td.SmallColHeading").findAll { it.text() != " " } }
    }

    def getRows() {
        find("tr").has("td.ColRow")
    }

    def getRowCellMap(int index) {
        def rows = getRows()
        def cells = rows[index].find("td")
        def headers = headers*.text()
        def resultMap = [:]
        for (def i = 0; i < headers.size(); i++) {
            resultMap.put(headers[i], cells[i])
        }
        resultMap
    }

    /**
     * Get Row Cell Map (cells as SimplePageContent) (No multiline row support)
     */
    def getRowCellMap(NonEmptyNavigator rowLine) {
        def headers = headers*.text()
        def resultMap = [:]
        def cells = rowLine.find("td").findAll {
            it.classes().contains("ColRow") || it.children().findAll { it.tag() != "img" }.size() > 0
        }
        for (def i = 0; i < headers.size(); i++) {
            resultMap.put(headers[i], cells[i])
        }
        resultMap
    }

    /**
     *
     * Get all rows cells maps (cell as SimplePageContent)
     */
    def getRowsCellsMap() {
        def rows = getRows()
        def result = []
        for (def j = 1; j < rows.size(); j++) {
            result.add(getRowCellMap(j))
        }
        result
    }

    def getColCellsByIndex(int index) {
        def rows = getRows()
        def colCells = []
        //Work only  with rows without spans. All others are skipped
        rows.findAll { it.find("td", colspan: contains(~/\d/)).size() == 0 }.each {
            def cell = it.find("td")[index]
            (cell instanceof EmptyNavigator) ?: colCells.add(cell)
        }
        colCells.toArray()
    }

    def getColCellsByName(String colName) {
        getColCellsByIndex(indexOfColumn(colName))
    }

    def findRowsByColumnValues(colValuesMap = [:]) {
        def result = []
        def rowsCellMap = getRowsCellsMap()
        outer:
        for (int i = 0; i < rowsCellMap.size(); i++) {
            for (int j = 0; j < colValuesMap.keySet().size(); j++) {
                def key = colValuesMap.keySet()[j]
                if (colValuesMap.get(key) != rowsCellMap[i].get(key).text()) {
                    j = 0
                    continue outer
                }
            }
            result.add(rowsCellMap[i])
        }
        result
    }

    def findRowWithMatchingText(String rowText) {
        def ndx = findRowIndexWithMatchingText(rowText)
        if (ndx >= 0) {
            rows[ndx]
        }
    }

    def findRowIndexWithMatchingText(String rowText) {
        def rowIndex = -1
        if ($("tr") instanceof NonEmptyNavigator) {
            rows.eachWithIndex { row, i ->
                if (row.text().matches(rowText)) rowIndex = i
            }
        }
        rowIndex
    }

    def getColumnCellsByName(colName) {
        def colIndex = indexOfColumn(colName)
        def result = []
        for (def j in (0..(rows.size() - 1))) {
            result.add(rows[j].find("td")[colIndex])
        }
        result
    }

    def findCellsInRowWithMatchingText(String rowText) {
        def rowElement = findRowWithMatchingText(rowText)
        rowElement.find("td")
    }


    def findRowByColumnValue(colName, colValue) {
        getRowCellMap(findRowIndexByColumnValue(colName, colValue))
    }

    def openRowWithText(String rowText, String linkColName) {
        getRowCellMap(findRowWithText(rowText)).get(linkColName).find("a").click()
    }

    def deleteRowWithText(String rowText, ignoreAbsence = true) {
        def results = findRowWithText(rowText)
        if (results.size() == 0) {
            if (ignoreAbsence == false) {
                throw new AssertionError("Required table row was not found by text " + rowText)
            } else {
                false
            }
        } else {
            results.find("img", title: startsWith("Delete")).parent().click()
            true
        }
    }

    def findRowWithText(String rowText) {
        def result = []
        def allRows = find("tr")
        for (def i in 0..allRows.size() - 1) {
            if (allRows[i].text().contains(rowText)) {
                result = allRows[i]
                break
            }
        }
        result
    }

    def findRowIndexByColumnValue(colName, colValue) {
        def result = null
        def rows = getRows()
        for (def i = 0; i < rows.size(); i++) {
            if (rows[i].has("td", colspan: contains(~/[2-99]/)).size() == 0) {
                def cells = rows[i].find("td")
                if (cells && (cells[indexOfColumn(colName)].text()?.contains(colValue))) {
                    result = i
                    break
                }
            }
        }
        result
    }

    def indexOfColumn(colName) {
        headers*.text().indexOf(colName)
    }


}

