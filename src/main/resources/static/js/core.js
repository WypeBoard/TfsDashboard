/**
 * Resize function without multiple trigger
 *
 * Usage:
 * $(window).smartresize(function(){
 *     // code here
 * });
 */
(function($,sr){
    // debouncing function from John Hann
    // http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
    var debounce = function (func, threshold, execAsap) {
      var timeout;

        return function debounced () {
            var obj = this, args = arguments;
            function delayed () {
                if (!execAsap)
                    func.apply(obj, args);
                timeout = null;
            }

            if (timeout)
                clearTimeout(timeout);
            else if (execAsap)
                func.apply(obj, args);

            timeout = setTimeout(delayed, threshold || 100);
        };
    };

    // smartresize
    jQuery.fn[sr] = function(fn){  return fn ? this.bind('resize', debounce(fn)) : this.trigger(sr); };

})(jQuery,'smartresize');

const $CURRENT_URL = window.location.href.split('#')[0].split('?')[0];
const $BODY = $('body');
const $MENU_TOGGLE = $('#menu_toggle');
const $SIDEBAR_MENU = $('#sidebar-menu');
const $SIDEBAR_FOOTER = $('.sidebar-footer');
const $LEFT_COL = $('.left_col');
const $RIGHT_COL = $('.right_col');
const $NAV_MENU = $('.nav_menu');
const $FOOTER = $('footer');

function menuEventHandler() {
    $SIDEBAR_MENU.find('li').removeClass('active');
    $SIDEBAR_MENU.find('li ul').slideUp();

}

function setContentHeight() {
        // reset height
        $RIGHT_COL.css('min-height', $(window).height());

        var bodyHeight = $BODY.outerHeight(),
            footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
            leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
            contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;

        // normalize content
        contentHeight -= $NAV_MENU.height() + footerHeight;

        $RIGHT_COL.css('min-height', contentHeight);
    };


$(document).ready(function() {
    setContentHeight();

    $SIDEBAR_MENU.find('a').on('click', function(ev) {
        var $li = $(this).parent();

        if ($li.is('.active')) {
            $li.removeClass('active')
            $('ul:first', $li).slideUp(function() {
                menuEventHandler();
            })
        } else if (!$li.parent().is('.child_menu')) {
            menuEventHandler();
        }


        $li.addClass('active');
        $('ul:first', $li).slideDown(function() {
            setContentHeight();
        });
    });

    // check active menu
    $SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('current-page');

    // recompute content when resizing
    $(window).smartresize(function () {
        setContentHeight();
    });
});