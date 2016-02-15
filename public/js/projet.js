/**
 * Created by Gishan on 08/02/2016.
 */

$(document).ready(function() {
    $('.btn-group .btn').click(function (e) {
        e.preventDefault();
        var self = $(this),
            controler = self.data('infos') || self.attr('data-infos');
        $('.btn-group .btn').removeClass('btn-active');
        $(this).addClass('btn-active');

    });

});

$(document).ajaxComplete(function() {
    $('.btn-group .btn').click(function (e) {
        e.preventDefault();
        var self = $(this),
            controler = self.data('infos') || self.attr('data-infos');
        $('.btn-group .btn').removeClass('btn-active');
        $(this).addClass('btn-active');

    });
});

$(function(){
    $( "#btn-modifierProjet" ).click(function() {
        //$("#div-consulterProjet").css("display","none");
        jQuery.fx.off = true;
        $("#div-consulterProjet").hide();
        $("#div-modifierProjet").show();
        jQuery.fx.off = false;
    });

    $("#creerSousTache").click(function() {

        $(this).attr('style', '');
    });
});