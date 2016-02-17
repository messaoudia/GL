/**
 * Created by Amin on 17/02/2016.
 */
$(function(){

    $(".sidebar-btn-red").click(function() {
        $('.navbar').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important; transition: none;");
        $('.pear-theme').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important;");
    });

    $(".sidebar-btn-green").click(function() {
        $('.navbar').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important; transition: none;");
        $('.pear-theme').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important;");
    });
});

function changeColorTopBar()
{
    var navbar = document.getElementsByClassName("pear-theme");
}