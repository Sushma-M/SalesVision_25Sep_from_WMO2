/* Define the property change handler. This function will be triggered when there is a change in the prefab property */

Prefab.onPropertyChange = function (key, newVal, oldVal) {
    switch (key) {
    case "youtubeurl":
        if (!newVal) {
            return;
        }
        newVal = newVal.replace("/watch?v=", "/embed/");
        newVal += (newVal.indexOf("?") === -1 ? "?" : "&") + "wmode=transparent";
        Prefab.url = newVal;
        break;
    case "allowfullscreen":
        var iframeEle = Prefab.Widgets.youtube_iframe.$element.find('iframe');
        if (!iframeEle.length) {
            return;
        }
        newVal ? iframeEle.attr(key, key) : iframeEle.removeAttr(key);
        break;
    }
};

/* this will be triggered after the prefab is initialized */

Prefab.onReady = function () {
    // do nothing
};

