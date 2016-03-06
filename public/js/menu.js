/**
 * Created by Amin on 17/02/2016.
 */
var needClick=true;
var special = false;
var selfBis;
var controlerBis;

$(document).on("click",".sidebar-btn-red", function(){
    var self = $(this),
        controler = self.data('infos') || self.attr('data-infos');
    // verif mot de passe
    if(!needClick){
        changeTopBarRed();
        changePage(self,controler);
        //$("#modal-check-mdp").removeAttr('data-backdrop');
        //$("#modal-check-mdp").removeAttr('data-keyboard');
    }else{
        selfBis = self;
        controlerBis = controler;
    }
    // on click sur le bouton obligatoire
});

$(document).on("click",".sidebar-btn-green", function(){
    changeTopBarGreen();
    var self = $(this),
        controler = self.data('infos') || self.attr('data-infos');
    changePage(self,controler);
});


$(document).on("click",".close", function(event){
    var attr = $("#modal-check-mdp").attr('data-backdrop');
    if (special == true) {
        special = false;
        needClick = false;
        $(location).attr('href',window.location.href);
        /*
         jsRoutes.controllers.AdminController.redirectDashboard().ajax({
         success: function(html) {
         var result = $('#wrapper',html);
         $('#modal-check-mdp').modal('toggle');
         alert($($(html).find('#wrapper')).html());
         //$('#wrapper').empty();
         console.log($('#wrapper').html());
         $('#wrapper').html(result);
         console.log($('#wrapper').html());
         }
         });*/

    }


});
    $(document).on("click","#adminBtn", function(event){
        var pswd = $("#passwordAdmin").val();

        jsRoutes.controllers.AdminController.checkMdpAdmin(pswd).ajax({
            success: function() {
                $("#errorMdpAdminP").html("");
                $("#errorMdpAdmin").hide();
                needClick = false;
                changeTopBarRed();
                changePage(selfBis,controlerBis);
                $("#passwordAdmin").val("");
                $(".sidebar-btn-red").removeAttr("data-target");
                $(".sidebar-btn-red").removeAttr("data-toggle");
                setTimeout(function(){
                    needClick = true;
                   // $("#modal-check-mdp").attr('data-backdrop', 'static');
                   // $("#modal-check-mdp").attr('data-keyboard','false');
                    // Si on est sur une page admin
                    if( $(".active").hasClass('sidebar-btn-red')){
                        //remove attribute close
                        $("#modalClose").removeAttr("data-dismiss");
                        $("#modal-check-mdp").modal('show');
                        special = true;
                    }
                },10000000);
                $('#modal-check-mdp').modal('toggle');
            },
            //Case we have a problem
            error: function(error){
                var messageDiv = "";
                messageDiv += '@Messages("errors") : ';
                if(error.responseJSON.mdpVide==true)
                {
                    messageDiv += '<br> - @Messages("mdpEmptyError")';
                }else if(error.responseJSON.mdpIncorrecte == true){
                    messageDiv += '<br> - @Messages("mdpIncorrecteError")';
                }
                $("#errorMdpAdminP").html(messageDiv);
                $("#errorMdpAdmin").show();
            }
        });







        /*jsRoutes.controllers.UtilisateurController.checkMdpAdmin(pswd).ajax({
            success: function(html) {

            },
            //Case we have a problem
            error: function(errorMessage){
                alert(errorMessage);
            }
        });*/
    });
    function changePage(objet,controler){
        $('#sidebar ul li').removeClass('active');
        objet.addClass('active');
        eval("jsRoutes.controllers."+controler).ajax({
            success: function(html) {
                var result = $('#refresh',html);
                $('#refresh').empty().html(result);
            },
            //Case we have a problem
            error: function(errorMessage){
                alert(errorMessage);
            }
        });
        jsRoutes.controllers.NotificationController.sendNotifications().ajax();
    }



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
