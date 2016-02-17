/**
 * Created by Amin on 17/02/2016.
 */
$(function(){

    $(".sidebar-btn-red").click(function() {
        changeTopBarRed();
    });

    $(".sidebar-btn-green").click(function() {
        changeTopBarGreen();
    });

    function changeTopBarRed()
    {
        $('.navbar').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important; transition: none;");
        $('.pear-theme').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important;");
        var navHeader = document.getElementById('nav-header');
        $(navHeader).addClass('nav-header-admin');
    }

    function changeTopBarGreen()
    {
        $('.navbar').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important; transition: none;");
        $('.pear-theme').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important;");
        var navHeader = document.getElementById('nav-header');
        $(navHeader).removeClass('nav-header-admin');
    }
});