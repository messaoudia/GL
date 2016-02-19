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

    $('#afficheListeProjet').click(function(){

        if($("#col-sidebar-liste-projet").is(":visible")){
            $('#col-sidebar-liste-projet').hide();
            $(this).css("width","25px");
            $("#col-consulterProjet").removeClass("col-md-10");
            $("#col-consulterProjet").addClass("col-md-12");
            $("#icon-show-liste-projet").removeClass("fa-outdent");
            $("#icon-show-liste-projet").addClass("fa-indent");
        }
        else{
            $('#col-sidebar-liste-projet').show();
            $(this).css("width","170px");
            $("#col-consulterProjet").removeClass("col-md-12");
            $("#col-consulterProjet").addClass("col-md-10");
            $("#icon-show-liste-projet").removeClass("fa-indent");
            $("#icon-show-liste-projet").addClass("fa-outdent");
        }
    });

});