package com.fortegrp.at.ui.utils

/**
 * Processing of Src selectors
 */
class SrcLocatorProcessor {
    /**
     *Get src locator from Src attribute
     * @param src string with locator
     */
    static def getLocatorFromSrc(src){
        return (src =~ /.*md5\/(.*)\/300\/300/)[0][1]
    }

}
