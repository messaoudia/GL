$(document).ready(function() {
    $('.btn-group .btn').click(function (e) {
        e.preventDefault();
        var self = $(this),
            controler = self.data('infos') || self.attr('data-infos');
        $('.btn-group .btn').removeClass('btn-active');
        $(this).addClass('btn-active');

    });

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

    /**
     * Methode Ajax pour aller récuperer des informations d'un client
     **/


});

$(document).ajaxComplete(function() {
    $('.btn-group .btn').click(function (e) {
        e.preventDefault();
        var self = $(this),
            controler = self.data('infos') || self.attr('data-infos');
        $('.btn-group .btn').removeClass('btn-active');
        $(this).addClass('btn-active');

    });

    $( "#btn-modifierProjet" ).click(function() {
        //$("#div-consulterProjet").css("display","none");
        jQuery.fx.off = true;
        $("#div-consulterProjet").hide();
        $("#div-modifierProjet").show();
        jQuery.fx.off = false;
    });

    $( "#btn-cancel-modifierProjet" ).click(function() {
        jQuery.fx.off = true;
        $("#div-modifierProjet").hide();
        $("#div-consulterProjet").show();
        jQuery.fx.off = false;
    });

    $( "#btn-modifierProjet-admin" ).click(function() {
        //$("#div-consulterProjet").css("display","none");

        jQuery.fx.off = true;
        $("#div-consulterProjet-admin").hide();
        $("#div-modifierProjet-admin").show();
        jQuery.fx.off = false;
    });

    $( "#btn-cancel-modifierProjet-admin" ).click(function() {
        jQuery.fx.off = true;
        $("#div-modifierProjet-admin").hide();
        $("#div-consulterProjet-admin").show();
        jQuery.fx.off = false;
    });

    $( "#btn-modifierProjet-client" ).click(function() {
        //$("#div-consulterProjet").css("display","none");
        jQuery.fx.off = true;
        $("#div-consulterProjet-client").hide();
        $("#div-modifierProjet-client").show();
        jQuery.fx.off = false;
    });

    $( "#btn-cancel-modifierProjet-client" ).click(function() {
        jQuery.fx.off = true;
        $("#div-modifierProjet-client").hide();
        $("#div-consulterProjet-client").show();
        jQuery.fx.off = false;
    });

    $("#creerSousTache").click(function() {
        $(this).attr('style', '');
    });


});

$(function(){

    $('.sidebar-projet').click(function(){
        $('.sidebar-projet.select').removeClass("select");
        $(this).addClass("select");

    });
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

    $(".header-sidebar-projet").click(function(){

        if($(this).next().is(":visible"))
        {
            next = $(this).next();
            while (next!=null && next.hasClass("client-project"))
            {
                next.hide();
                next = next.next();
            }
        }
        else {
            next = $(this).next();
            while (next!=null && next.hasClass("client-project"))
            {
                next.show();
                next = next.next();
            }
        }

        $('.liste-projet').css('height',"100%");
        height = $('.liste-projet').css('height');
        height = parseInt(height);
        height -= 170;
        $('.liste-projet').css('height',height);

    });

});