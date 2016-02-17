/**
 * Created by Amin on 17/02/2016.
 */
$(function(){

    $("#sidebar-dashboard").click(function() {
        $('.navbar').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important; transition: none;");
        $('.pear-theme').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important;");
    });
});

function changeColorTopBar()
{
    var navbar = document.getElementsByClassName("pear-theme");
}