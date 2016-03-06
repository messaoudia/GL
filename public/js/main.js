// Message de traduction map
var map = new Object(); // or var map = {};

jsRoutes.controllers.Application.messagesMap().ajax({
    success: function(data){
        map = data;
    },
    error:function(errorMessage){
        console.error(errorMessage);
    }
})

var messages = function(key){
    return map[key];
}

// ============= DO NOT TOUCH ==================

function hideSideBarProjet()
{
    $('#col-sidebar-liste-projet').hide();
    $('#afficheListeProjet').css("width","25px");
    $(".col-consulterProjet").removeClass("col-md-10");
    $(".col-consulterProjet").addClass("col-md-12");
    $("#icon-show-liste-projet").removeClass("fa-outdent");
    $("#icon-show-liste-projet").addClass("fa-indent");
    $('.liste-projet').css('height',"100%");
    height = $('.liste-projet').css('height');
    height = parseInt(height);
    height -= 150;
    $('.liste-projet').css('height',height);
    $('.liste-projet-client').css('height',"100%");
    height = $('.liste-projet-client').css('height');
    height = parseInt(height);
    height -= 200;
    $('.liste-projet-client').css('height',height);

}
function showSideBarProjet()
{
    $('#col-sidebar-liste-projet').show();
    $('#afficheListeProjet').css("width","170px");
    $(".col-consulterProjet").removeClass("col-md-12");
    $(".col-consulterProjet").addClass("col-md-10");
    $("#icon-show-liste-projet").removeClass("fa-indent");
    $("#icon-show-liste-projet").addClass("fa-outdent");
    $('.liste-projet').css('height',"100%");
    height = $('.liste-projet').css('height');
    height = parseInt(height);
    height -= 150;
    $('.liste-projet').css('height',height);
    $('.liste-projet-client').css('height',"100%");
    height = $('.liste-projet-client').css('height');
    height = parseInt(height);
    height -= 200;
    $('.liste-projet-client').css('height',height);

}
$(document).on('click','#afficheListeProjet', function(event){
    if($("#col-sidebar-liste-projet").is(":visible")){
        hideSideBarProjet();

    }
    else
    {
        showSideBarProjet();
    }
});


$(document).on('click','#afficheRetour', function(event){

    if($("#col-sidebar-retour").is(":visible")){
        hideSideBarRetour();
    }
    else
    {
        showSideBarRetour();
    }
});

function hideSideBarRetour()
{
    $('#col-sidebar-retour').hide();
    $('#afficheRetour').css("width","25px");
    $("#col-consulterProjet").removeClass("col-md-10");
    $("#col-consulterProjet").addClass("col-md-12");
    $("#icon-show-liste-projet").removeClass("fa-outdent");
    $("#icon-show-liste-projet").addClass("fa-indent");
}
function showSideBarRetour()
{
    $('#col-sidebar-retour').show();
    $('#afficheRetour').css("width","170px");
    $("#col-consulterProjet").removeClass("col-md-12");
    $("#col-consulterProjet").addClass("col-md-10");
    $("#icon-show-liste-projet").removeClass("fa-indent");
    $("#icon-show-liste-projet").addClass("fa-outdent");
}


var changeModeDraftProjet = function(idProjet){
    console.log("Je suis la");
    if($('#checkbox-draft-projet-'+idProjet).is(':checked')){
        console.log("Je suis checked");
        $('#nestable-projet-'+idProjet).removeClass("dd-nodrag");
        $('.id-tache').hide();
    }
    else{
        console.log("Je suis pas checked");
        var draftParsedAsJson = parseDraft(idProjet);

        $('#nestable-projet-'+idProjet).addClass("dd-nodrag");
        $('.id-tache').show();


        console.log(draftParsedAsJson);
        jsRoutes.controllers.ProjetController.sendDraf().ajax({
            data: draftParsedAsJson,
            dataType: "json",
            contentType: "application/json",
            success : function(data) {
                console.log(data);

                // Refresh project view
                jsRoutes.controllers.ProjetController.afficheProjet(idProjet).ajax({
                    success: function(data){
                        $('#projet-'+idProjet).html(data);
                        $('#client-projet-'+idProjet).html(data);
                        $('#projet-'+idProjet).show();

                    },
                    error:function(errorMessage){
                        console.log(errorMessage);
                    }
                });

            },
            error: function(errorMessage){
                $('#modal-draft-projet').modal('show');
                console.error(errorMessage);
            }
        });
    }
}

var changeModeDraftClient = function(idProjet){
    console.log("Je suis la");
    if($('#checkbox-draft-client-'+idProjet).is(':checked')){
        console.log("Je suis checked");
        $('#nestable-client-projet-'+idProjet).removeClass("dd-nodrag");
        $('.id-tache').hide();
    }
    else{
        console.log("Je suis pas checked");
        $('#nestable-client-projet-'+idProjet).addClass("dd-nodrag");
        $('.id-tache').show();
    }
}


var userRow;
$requestUtilisateursArchives = false;
$requestClientsArchives = false;
$requestProjetsTermines = false;
$requestProjetsArchives = false;
var $tmpTr;
var $tmpTrAdminClient;
var clientRow;
var $tmpTrAdminUser;

function updateSideBarClientArchive(checkbox)
{
    if($(checkbox).is(":checked")) {
        $(".projet-finished-sidebar").show();
        console.log("TODO check si ok : j'affiche projet termine");
    }
    else {
        $(".projet-finished-sidebar").hide();
        console.log("TODO check si ok : je cache projet termine");

    }
}

$(document).on('click','.createSubTask', function(event){
    var btn = $(this);
    var jsonTache = "";
    console.log("creer sous tache de "+btn.attr("data"));

    $('#formModifierTacheC').validate().resetForm();
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));

    //FIXME Dates limites
    jsRoutes.controllers.TacheController.getTacheById(btn.attr("data")).ajax({
        success: function(tache) {
            jsonTache = tache;
            var dateDebut = tache.dateDebut;
            var dateFinTard = tache.dateFinTard;
            $('#datepicker_date_debutC .input-group.date').datepicker('option', {
                minDate: new Date(dateDebut.split("/")[2],dateDebut.split("/")[1],dateDebut.split("/")[0]),
                maxDate: new Date(dateFinTard.split("/")[2],dateFinTard.split("/")[1],dateFinTard.split("/")[0]),
            });
            /*$('#datepicker_date_fin_totC .input-group.date').datepicker('option', {
             minDate: new Date(dateDebut.split("/")[2],dateDebut.split("/")[1],dateDebut.split("/")[0]),
             maxDate: new Date(dateFinTard.split("/")[2],dateFinTard.split("/")[1],dateFinTard.split("/")[0]),
             });
             $('#datepicker_date_fin_tardC .input-group.date').datepicker('option', {
             minDate: new Date(dateDebut.split("/")[2],dateDebut.split("/")[1],dateDebut.split("/")[0]),
             maxDate: new Date(dateFinTard.split("/")[2],dateFinTard.split("/")[1],dateFinTard.split("/")[0]),
             });*/

            //Interlocuteurs
            jsRoutes.controllers.DashboardController.getAllInterlocuteur(tache.projet.id).ajax({
                success: function(interlocuteursClient){
                    var listCreer = "";
                    $(interlocuteursClient).each(function(i,interlocuteur){
                        listCreer+='<li><div class="checkbox checkbox-success checkbox-dropdown">';
                        listCreer+='<input id="checkbox-interlocuteurC-'+i+'" type="checkbox" value="'+interlocuteur.id+'">';
                        listCreer+='<label for="checkbox-interlocuteurC-'+i+'">';
                        listCreer+=interlocuteur.nom+' '+ interlocuteur.prenom+'</label></div></li>';
                    });

                    $('#interlocuteurs-modifierC').html(listCreer);

                },
                error: function(errorMessage){
                    alert(errorMessage);
                }
            });

            //Predecesseurs possible
            jsRoutes.controllers.DashboardController.getAllPredecesseursPossible(tache.id).ajax({
                success: function(taches){
                    //console.log(taches);
                    var list = "";

                    $(taches).each(function(index, t) {
                        if(t.id==tache.predecesseurId){
                            list+='<option value="'+t.id+'" selected>'+t.id+' - '+t.nom+'</option>';
                        }
                        else {
                            list+='<option value="'+t.id+'">'+t.id+' - '+t.nom+'</option>';
                        }
                    });

                    $('#form-tache-predecesseurC').html(list);
                },
                error: function(errorMessage){
                    alert(errorMessage);
                }
            });

            //Successeurs possible
            jsRoutes.controllers.DashboardController.getAllSucesseursPossible(tache.id).ajax({
                success: function(taches){
                    //console.log(taches);
                    var list = "";

                    $(taches).each(function(index, t) {
                        var isSuccesseur = false;
                        $(tache.successeurs).each(function(index,s){
                            if(t.id == s.id){
                                isSuccesseur = true;
                                return;
                            }
                        });
                        if(isSuccesseur){
                            list+='<option value="'+t.id+'" selected>'+t.id+' - '+t.nom+'</option>';
                        }else{
                            list+='<option value="'+t.id+'">'+t.id+' - '+t.nom+'</option>';
                        }
                    });

                    $('#form-tache-successeurC').html(list);
                },
                error: function(errorMessage){
                    alert(errorMessage);
                }
            });
            //Responsable de tache
            jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
                success: function(utilisateurs){
                    var list = "";
                    $(utilisateurs).each(function(index, u) {
                        list+='<option value="'+u.id+'">'+u.nom+' '+u.prenom+'</option>';
                    });

                    $('#responsableTacheModifierC').html(list);
                },
                error: function(errorMessage){
                    alert(errorMessage);
                }
            });
        }
    });

    $('#btn-valider-modifierTacheC').attr("data",btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick","creerSousTache(this); return false;");
});

var creerSousTache = function(btn){
    console.log("main.scala : creerSousTache appelé");
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);

    if(dataToSend == -1){

    }else{
        console.log("main.scala : appel du controlleur creerSousTache");
        jsRoutes.controllers.TacheController.creerSousTache(idTacheSelect).ajax({
            data: dataToSend,
            success : function(data) {
                console.log("main.scala : success");
                $('#modal-tache-creer').modal('toggle');


                jsRoutes.controllers.TacheController.getTacheById(idTacheSelect).ajax({
                    success : function(tache){
                        var projetId = tache.projet.id;
                        // Refresh project view
                        jsRoutes.controllers.ProjetController.afficheProjet(projetId).ajax({
                            success: function(data){
                                $('#projet-'+projetId).html(data);
                                $('#client-projet-'+projetId).html(data);
                                $('#projet-'+projetId).show();
                                console.log("AfficheProjet OK : "+projetId);
                            },
                            error:function(errorMessage){
                                console.log(errorMessage);
                                console.log("AfficheProjet KO : "+projetId);
                            }
                        });
                    },
                    error : function(errorMessage){
                        console.log(errorMessage);
                    }
                });


            },
            error : function(errorMessage){
                console.log("main.scala > creerSousTache => error");
                console.log("-----------> " + errorMessage)
            }
        });
    }
}

$(document).on('click','.createTaskHaut', function(event){
    var btn = $(this);
    console.log("creer tache haut de "+btn.attr("data"));

    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));



    $('#btn-valider-modifierTacheC').attr("data",btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick","creerTacheHaut(this); return false;");
});

var creerTacheHaut = function(btn){
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);

}

$(document).on('click','.createTaskBas', function(event){
    var btn = $(this);

    console.log("creer tache bas de "+btn.attr("data"));
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));



    $('#btn-valider-modifierTacheC').attr("data",btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick","creerTacheBas(this); return false;");
});

var creerTacheBas = function(btn){
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);


}

var creerDataFormulaireCreationTache = function(btn){
    var form = $(btn).attr("form");
    form = "#"+form;

    if($(form).valid()){
        var serialize = $(form).serialize();
        console.log(serialize);

        //PREDECESSEUR
        var idPredecesseur = "";
        if($('#form-tache-predecesseuCr').select2().val() != null){
            idPredecesseur = $('#form-tache-predecesseurC').select2().val()[0];
            console.log("idPredecesseur"+idPredecesseur);
        }

        var tabSuccesseurs = [];
        //SUCCESSEUR
        $("#form-tache-successeurC option").each(function() {
            if($(this).is(':selected')){
                console.log("selected : "+$(this).val());
                tabSuccesseurs.push($(this).val());
            }
        });

        //RESPONSABLE DE TACHE
        var idResponsableTache = $('#responsableTacheModifierC').select2().val()[0];
        console.log("idReponsableTache"+idResponsableTache);

        //INTERLOCUTEURS EXTERNES
        var nbInterlocuteurs = $("#interlocuteurs-modifierC li").length;
        var tabInterlocuteurs = [];

        for (i = 0; i < nbInterlocuteurs; i++) {
            if($("#checkbox-interlocuteurC-"+i).is(':checked')){
                console.log("checked : "+$("#checkbox-interlocuteurC-"+i).attr('value'));
                tabInterlocuteurs.push($("#checkbox-interlocuteurC-"+i).attr('value'));
            }
        }

        var dataToSend = serialize+"&predecesseurC="+idPredecesseur;
        dataToSend += "&successeursC=";

        for (var i = 0; i < tabSuccesseurs.length; i++){
            dataToSend += tabSuccesseurs[i]+",";
        }

        dataToSend += "&responsableC="+idResponsableTache;

        dataToSend += "&interlocuteursC=";

        for (var i = 0; i < tabInterlocuteurs.length; i++){
            dataToSend += tabInterlocuteurs[i]+",";
        }

        console.log("Data SEND : "+dataToSend);

        return dataToSend;
    }else{
        return -1;
    }
}

$(document).on('click','#interlocuteurs-modifier', function(event){
    event.stopPropagation();
});

$(document).on('click','#interlocuteurs-modifierC', function(event){
    event.stopPropagation();
});

$(document).on('click','#dataTables-admin-user tr td:not(:last-child)', function(){
    var id = $(this).parent('tr').attr('value');
    userRow = $(this).parent('tr');
    console.log("id.on = "+id);
    jsRoutes.controllers.AdminController.afficherModalUtilisateur(id).ajax({
        success: function(utilisateur) {
            //console.log(utilisateur);
            /* fill modal values*/
            if(utilisateur.archive)
            {
                $('#formLastNameD').val(utilisateur.nom);
                $('#formFirstNameD').val(utilisateur.prenom);
                $('#formEmailD').val(utilisateur.email);
                $('#formTelD').val(utilisateur.telephone);
            }
            else {
                $('#formLastName').val(utilisateur.nom);
                $('#formFirstName').val(utilisateur.prenom);
                $('#formEmail').val(utilisateur.email);
                $('#formTel').val(utilisateur.telephone);
            }


            //TODO mettre la condition si !admin sinon
            if(true)
            {
                // si le bouton a deja la classe ca sert a rien de changer
                if(!$("#btnAdminNonModifier").hasClass("btn-active"))
                {
                    $("#btnAdminOuiModifier").removeClass("btn-active")
                    $("#btnAdminNonModifier").addClass("btn-active");
                }
            }
            else
            {
                if(!$("#btnAdminOuiModifier").hasClass("btn-active"))
                {
                    $("#btnAdminNonModifier").removeClass("btn-active")
                    $("#btnAdminOuiModifier").addClass("btn-active");
                }
            }
        },
        //Case we have a problem
        error: function(errorMessage){
            alert(errorMessage);
            console.log(errorMessage);
        }
    });
});

$(document).on('click','#dataTables-admin-projet tr td:not(:last-child)', function(){
    var $valueTr = $(this).parent('tr').attr('value');
    jsRoutes.controllers.AdminController.afficherAdminProjetsSelect($valueTr).ajax({
        success: function(html) {
            var result = $('#refresh',html);
            $('#refresh').empty().html(result);
        },
        //Case we have a problem
        error: function(errorMessage){
            alert(errorMessage);
        }
    });
});
$(document).on('click','#dataTables-admin-client-body tr td:last-child', function(){

    var parent = $(this).parent('tr');
    var idC = parent.attr('value');
    jsRoutes.controllers.AdminController.afficherModalClient(idC).ajax({
        success: function(client){
            $("#delete-project-name").empty();
            $("#delete-project-name").append(client.nom);
            $tmpTrAdminClient = parent;
        }
    });
});

$(document).on('click','#dataTables-admin-user tr td:last-child', function(){
    $tmpTrAdminUser = $(this).parent('tr');

    var idU = $tmpTrAdminUser.attr('value');
    jsRoutes.controllers.AdminController.afficherModalUtilisateur(idU).ajax({
        success: function(u){
            $("#delete-utilisateur-name").empty();
            $("#delete-utilisateur-name").append(" "+u.prenom+" "+u.nom+" ("+u.email+")");
            $("#delete-utilisateur-name-confirm").empty();
            $("#delete-utilisateur-name-confirm").append(" "+u.prenom+" "+u.nom+" ("+u.email+")");
            jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
                success: function(utilisateurs){
                    console.log(utilisateurs);
                    jsRoutes.controllers.UtilisateurController.listProjetsUtilisateur(idU).ajax({
                        success: function(listProjets){
                            console.log(listProjets);
                            //listProjets
                            var projetTableBody = $('#table-modal-suppr-user-projet-body');
                            projetTableBody.empty();

                            var p ="";
                            if(listProjets.length != 0){
                                $(listProjets).each(function(index, projet) {
                                    p+=('<tr value="'+projet.id+'">');
                                    p+=('<td>'+projet.nom+'</td>');
                                    if(utilisateurs.length != 0){
                                        p+=('<td><select class="form-control select2-respo-projet" style="width:100%;" multiple="single">');
                                        $(utilisateurs).each(function(index,u){
                                            // lister tous les utilisaturs en cours sauf l'user courant
                                            if(u.id != idU){
                                                p+=('<option value="'+u.id+'">'+u.nom+' '+u.prenom+' ('+u.email+')</option>');
                                            }//console.log(u.nom);
                                        });
                                        p+=('</select></td>');
                                    }
                                    p+=('</tr>');

                                });
                                projetTableBody.append(p);
                                p = "";
                            }
                        }
                    });

                    jsRoutes.controllers.UtilisateurController.listTachesUtilisateur(idU).ajax({
                        success: function(listTaches){
                            console.log(listTaches);
                            var tacheeBody = $('#table-modal-suppr-user-tache-body');
                            tacheeBody.empty();

                            var p="";
                            if(listTaches.length != 0){
                                $(listTaches).each(function(index, tache) {
                                    p+=('<tr value="'+tache.id+'">');
                                    p+=('<td>'+tache.nom+'</td>');
                                    p+=('<td>'+tache.projet.nom+'</td>');
                                    if(utilisateurs.length != 0){
                                        p+=('<td><select class="form-control select2-respo-tache" style="width:100%;" multiple="single">');
                                        $(utilisateurs).each(function(index,u){
                                            // lister tous les utilisaturs en cours sauf l'user courant
                                            if(u.id != idU){
                                                p+=('<option value="'+u.id+'">'+u.nom+' '+u.prenom+' ('+u.email+')</option>');
                                            }//console.log(u.nom);
                                        });
                                        p+=('</select></td>');
                                    }
                                    p+=('</tr>');

                                });
                                tacheeBody.append(p);
                                p = "";
                            }
                        }
                    });
                }
            });
        }
    });
});


var d ="";
var modalId;

function modal(client,idC){
    $("#dataTables-admin-client").dataTable().fnDestroy();
    if(client.archiver)
    {
        d="D";
    }

    $('#formClientName'+d).val(client.nom);
    $('#formClientAdress'+d).val(client.adresseClient.adresse);
    $('#formZipCode'+d).val(client.adresseClient.zipCode);
    $('#formCity'+d).val(client.adresseClient.ville);
    $('#formCountry'+d).val(client.adresseClient.pays);

    $('#client-priority-1'+d).removeClass("btn-active");
    $('#client-priority-2'+d).removeClass("btn-active");
    $('#client-priority-3'+d).removeClass("btn-active");
    $('#client-priority-'+client.priorite+d).addClass("btn-active");

    jsRoutes.controllers.ProjetController.afficherProjetsClient(idC).ajax({
        success: function(listProjets) {
            console.log("sucess -----");
            var projetTableBody = $('#table-modal-client-projets-body'+d);
            projetTableBody.empty();
            console.log(listProjets);
            $("#dataTables-admin-client"+d).dataTable().fnDestroy();
            if(listProjets.length != 0){
                $(listProjets).each(function(index, projet) {
                    var p ="";
                    p+=('<tr value="'+projet.id+'">');
                    p+=('<td class="first-td">'+projet.nom+'</td>');
                    if(d=="D" || projet.archive == true )
                    {
                        p+=('<td class="td-btn-suppr-disable" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    else
                    {
                        p+=('<td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    p+=('</tr>');

                    projetTableBody.append(p);
                });
            }
        },
        error: function(errorMessage){
            console.log("error : "+errorMessage)
        }
    });

    jsRoutes.controllers.ContactController.afficherContactsClient(idC).ajax({
        success: function(listContacts) {
            var contactsTableBody = $('#table-modal-client-contacts-body'+d);
            contactsTableBody.empty();
            console.log(listContacts);
            $("#dataTables-admin-client"+d).dataTable().fnDestroy();
            if(listContacts.length != 0){
                $(listContacts).each(function(index, contact) {
                    var c ="";
                    c+=('<tr value="'+contact.id+'">');
                    c+=('<td class="first-td">'+contact.nom+'</td>');
                    c+=('<td class="first-td">'+contact.prenom+'</td>');
                    c+=('<td style="display:none;">'+contact.email+'</td>');
                    c+=('<td style="display:none;">'+contact.telephone+'</td>');
                    if(d=="D" || contact.archive == true)
                    {
                        c+=('<td class="td-btn-suppr-disable" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    else
                    {
                        c+=('<td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }

                    c+=('</tr>');

                    contactsTableBody.append(c);
                });
            }
        },
        error: function(errorMessage){
            console.log("error : "+errorMessage)
        }
    });

}
$(document).on('click','#dataTables-admin-client tr td:not(:last-child)', function(){
    var idC = $(this).parent('tr').attr('value');
    clientRow = $(this).parent('tr');
    jsRoutes.controllers.AdminController.afficherModalClient(idC).ajax({
        success: function(client) {
            //console.log(client);
            console.log("client : "+client);
            modal(client, idC);
        },
        //Case we have a problem
        error: function(errorMessage){
            alert(errorMessage);
        }
    });
});
//dataTables-admin-client
var supprimerProjet = function(){
    var $value = $tmpTr.attr('value');
    console.log($value);
    jsRoutes.controllers.AdminController.supprimerProjet($value).ajax({
        success: function(projetArchive) {
            console.log("Archie JSON : "+JSON.stringify(projetArchive));
            if(projetArchive.avancementGlobal==100)
            {
                $tmpTr.removeClass("projet-finished");
                $tmpTr.addClass("projet-archived-finished");

                if(!$(checkBoxProjetTermine).is(":checked") || !$(checkBoxProjetArchive).is(":checked")) {
                    $tmpTr.hide();
                }
            }
            else{
                $tmpTr.addClass("projet-archived");
            }
        },
        error: function(errorMessage,codeerror){
            alert(errorMessage);
            alert(codeerror);
        }
    });
}


var activerOuDesactiverNotification = function(idTache, idUser){

    jsRoutes.controllers.NotificationController.activerOuDesactiverNotificationTache(idTache, idUser).ajax({
        success: function() {
            var iconeToChange = $('#notif-icon-tache-' + idTache);
            if(iconeToChange.hasClass('fa-bell')){
                iconeToChange.removeClass('fa-bell');
                iconeToChange.addClass('fa-bell-slash-o');
            }
            else if(iconeToChange.hasClass('fa-bell-slash-o')){
                iconeToChange.removeClass('fa-bell-slash-o');
                iconeToChange.addClass('fa-bell');
            }

        },
        //Case we have a problem
        error: function(errorMessage){
        }
    });
}

var selectUtilisateursASuivre = function(idUserConnecte){
    var listUtilisateurs = $('#searchContact-select2').val();
    //console.log("List User : " + listUtilisateurs);
    if(listUtilisateurs == null){
        listUtilisateurs = "";
    }
    jsRoutes.controllers.UtilisateurController.modifierUtilisateursASuivre(idUserConnecte, listUtilisateurs).ajax();
}

var activeOuDesactiveNotifMesActions = function(idUserConnecte) {
    var isChecked = $('#checkbox-changes').is(':checked');
    console.log("activeOuDesactiveNotifMesActions : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationMesActions(idUserConnecte, isChecked).ajax();
}

var activeOuDesactiveNotifTachesPresqueTerminees = function(idUserConnecte) {
    var isChecked = $('#checkbox-tasks-almost-finish').is(':checked');
    console.log("activeOuDesactiveNotifTachesPresqueTerminees : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationTachesPresqueFinies(idUserConnecte, isChecked).ajax();
}

var activeOuDesactiveNotifTachesRetardees = function(idUserConnecte) {
    var isChecked = $('#checkbox-tasks-late').is(':checked');
    console.log("activeOuDesactiveNotifTachesRetardees : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationTachesRetardees(idUserConnecte, isChecked).ajax();
}

var saveBlocNote = function(idUser){
    console.log("Bloc note : " + $('#bloc-notes-tdb').val());
    jsRoutes.controllers.DashboardController.saveBlocNote(idUser, $('#bloc-notes-tdb').val()).ajax();
}

$('#checkbox-notif-all-selected').click(function() {
    if($('#checkbox-notif-all-selected').is(':checked')){
        $("div.checkbox-notif input[type=checkbox]").each(function(){
            $(this).attr('checked', true);
        });
    }
    else {
        $("div.checkbox-notif input[type=checkbox]").each(function(){
            $(this).attr('checked', false);
        });
    }
});


var clickNotificationsSupprimer = function(idUser){
    var listIdNotif = "";
    $("div.checkbox-notif input:checked").each(function(){
        listIdNotif += $(this).attr("name") + ",";
    });
    if(listIdNotif.length > 0){
        listIdNotif = listIdNotif.substring(0, listIdNotif.length-1);
        console.log(listIdNotif);
        jsRoutes.controllers.NotificationController.clickNotificationsSupprimer(idUser, listIdNotif).ajax({
            success: function(nbNotifNonLues){
                var listIdNotifSplit = listIdNotif.split(",");
                for(var i=0; i<listIdNotifSplit.length; i++){
                    var idNotif = listIdNotifSplit[i];
                    $('#notif-' + idNotif).remove();
                    $('#nbNotifNonLues-pageNotif').html(nbNotifNonLues);
                    $('#nbNotifNonLues-topbar').html(nbNotifNonLues);
                    console.log("Nb de notifs non lues = " + nbNotifNonLues);
                }
            },
            error : function(){
            }
        });
    }
}

var changePassword = function(idUser){
    var previousPassword = $('#previousPassword').val();
    var newPassword = $('#newPassword').val();
    var confirmNewPassword = $('#newPasswordConfirm').val();
    jsRoutes.controllers.UtilisateurController.changePassword(idUser, previousPassword, newPassword, confirmNewPassword).ajax({
        success: function(){
            console.log("Modification password ok");
            $('#previousPassword').val('');
            $('#newPassword').val('');
            $('#newPasswordConfirm').val('');
            $('#errorMessagePreviousPassword').hide();
            $('#errorMessageNewPassword').hide();
            $('#errorMessageNewPasswordConfirm').hide();
            $("#successChangePassword").show();
            setTimeout(function(){
                $("#successChangePassword").hide();
            },2000);
        },
        error: function(errorMessage){
            console.log("Modification password ko");
            console.log(errorMessage.responseJSON);
            console.log(errorMessage.responseJSON.previousPasswordCorrect);
            console.log(errorMessage.responseJSON.newPasswordCorrect);
            console.log(errorMessage.responseJSON.newPasswordCorrect);

            if(errorMessage.responseJSON.previousPasswordCorrect==false){
                $('#errorMessagePreviousPassword').show();
            } else {
                $('#errorMessagePreviousPassword').hide();
            }
            if(errorMessage.responseJSON.newPasswordCorrect==false){
                $('#errorMessageNewPassword').show();
            } else {
                $('#errorMessageNewPassword').hide();
            }
            if(errorMessage.responseJSON.confirmNewPasswordCorrect==false){
                $('#errorMessageNewPasswordConfirm').show();
            } else {
                $('#errorMessageNewPasswordConfirm').hide();
            }
        }
    });
}

var activeModificationProjetDansProjet = function(idProjet){
    jQuery.fx.off = true;
    $("#div-consulterProjet-" + idProjet).hide();
    $("#div-modifierProjet-" + idProjet).show();
    jQuery.fx.off = false;
}

var desactiveModificationProjetDansProjet = function(idProjet){
    jQuery.fx.off = true;
    $("#div-modifierProjet-" + idProjet).hide();
    $("#div-consulterProjet-" + idProjet).show();
    jQuery.fx.off = false;
}

var activeModificationProjetDansClient = function(idProjet){
    jQuery.fx.off = true;
    $("#div-consulterProjet-client-" + idProjet).hide();
    $("#div-modifierProjet-client-" + idProjet).show();
    jQuery.fx.off = false;
}

var desactiveModificationProjetDansClient = function(idProjet){
    jQuery.fx.off = true;
    $("#div-modifierProjet-client-" + idProjet).hide();
    $("#div-consulterProjet-client-" + idProjet).show();
    jQuery.fx.off = false;
}

var afficherNotifications = function () {
    //e.preventDefault();
    jsRoutes.controllers.NotificationController.afficherNotifications().ajax({
        success: function(html) {
            var result = $('#refresh',html).html();
            $('#refresh').empty().html(result);

        },
        //Case we have a problem
        error: function(errorMessage){
            alert(errorMessage);
        }
    });
}


/**
 * Methode Ajax pour aller récuperer des informations d'un utilisateur
 **/
var afficherModalUtilisateur = function (t) {

    var id = $(t).attr('value');
    jsRoutes.controllers.AdminController.afficherModalUtilisateur(id).ajax({
        success: function(utilisateur) {
            //console.log(utilisateur);
            $("#dataTables-admin-user").dataTable().fnDestroy();
            /* fill modal values*/
            $('.formLastName').val(utilisateur.nom);
            $('.formFirstName').val(utilisateur.prenom);
            $('.formEmail').val(utilisateur.email);
            $('.formTel').val(utilisateur.telephone);
        },
        //Case we have a problem
        error: function(errorMessage){
            alert(errorMessage);
        }
    });
}


var supprContact = function(td){
    var tr = $(td).parent('tr');
    tr.remove();
    var rowCount = $('#tableContact tbody tr').length;
    if(rowCount == 0){
        $('#listContactAjout').hide();
    }
}



var afficherAdminProjets = function(){
    jsRoutes.controllers.AdminController.afficherAdminProjets().ajax({
        success: function(html) {
            var result = $('#refresh',html);
            $('#refresh').empty().html(result);
        },
        error: function(errorMessage){
            alert(errorMessage);
        }
    });
}

function notifPopupTache(fa)
{
    //TODO traitement des notifs
    if($(fa).hasClass('fa-bell-slash'))
    {
        $(fa).removeClass('fa-bell-slash');
        $(fa).addClass('fa-bell');
    }
    else {
        $(fa).addClass('fa-bell-slash');
        $(fa).removeClass('fa-bell');
    }

}

function listContains(list,obj) {
    for(var i in list)
    {
        if(list[i].email==obj.email)
        {
            return true;
        }
    }
    return false;
}
var compareJSON = function(obj1, obj2) {
    var ret = {};
    var k = 0;
    for(var i in obj1) {
        if(!listContains(obj2,obj1[i])) {
            ret[k] = obj1[i];
            k++;
        }
    }
    return ret;
};

var updateIndisponibleTache = function() {
    if($('#btn-indisponibleTache i').hasClass("fa-lock"))
    {

        var idTache = $('#btn-indisponibleTache').attr("data");
        jsRoutes.controllers.ProjetController.updateTacheToDisponible(idTache).ajax({
            success: function(tache) {
                $('#btn-indisponibleTache i').removeClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");
                $('#btn-indisponibleTache i').addClass("fa-unlock")
                $('#btn-indisponibleTache-modifier i').addClass("fa-unlock");

                $('#formModifierChargeInitiale').removeAttr("disabled");
                $('#formModifierChargeRestante').removeAttr("disabled");
                $('#formModifierChargeConsommee').removeAttr("disabled");

                console.log("la tache "+$('#btn-indisponibleTache').attr("data")+" devient disponible");

            },
            error: function(errorMessage){
                alert(errorMessage);
            }
        });
    }
    else {

        var idTache = $('#btn-indisponibleTache').attr("data");

        jsRoutes.controllers.ProjetController.updateTacheToIndisponible(idTache).ajax({
            success: function(tache) {
                $('#btn-indisponibleTache i').removeClass("fa-unlock");
                $('#btn-indisponibleTache i').addClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-lock");
                console.log("la tache "+$('#btn-indisponibleTache').attr("data")+" devient indisponible");
                $('#formModifierChargeInitiale').attr("disabled","");
                $('#formModifierChargeRestante').attr("disabled","");
                $('#formModifierChargeConsommee').attr("disabled","");
            },
            error: function(errorMessage){
                alert(errorMessage);
            }
        });

    }
}


var updateIndisponibleTacheModifier = function() {
    if($('#btn-indisponibleTache-modifier i').hasClass("fa-lock"))
    {

        var idTache = $('#btn-indisponibleTache-modifier').attr("data");
        jsRoutes.controllers.ProjetController.updateTacheToDisponible(idTache).ajax({
            success: function(tache) {
                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-unlock");
                $('#btn-indisponibleTache i').removeClass("fa-lock");
                $('#btn-indisponibleTache i').addClass("fa-unlock")
                console.log("la tache "+$('#btn-indisponibleTache-modifier').attr("data")+" devient disponible");
                $('#formModifierChargeInitiale').removeAttr("disabled");
                $('#formModifierChargeRestante').removeAttr("disabled");
                $('#formModifierChargeConsommee').removeAttr("disabled");
            },
            error: function(errorMessage){
                alert(errorMessage);
            }
        });
    }
    else {

        var idTache = $('#btn-indisponibleTache-modifier').attr("data");

        jsRoutes.controllers.ProjetController.updateTacheToIndisponible(idTache).ajax({
            success: function(tache) {
                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-lock");
                $('#btn-indisponibleTache i').removeClass("fa-unlock");
                $('#btn-indisponibleTache i').addClass("fa-lock");
                console.log("la tache "+$('#btn-indisponibleTache-modifier').attr("data")+" devient indisponible");
                $('#formModifierChargeInitiale').attr("disabled","");
                $('#formModifierChargeRestante').attr("disabled","");
                $('#formModifierChargeConsommee').attr("disabled","");
            },
            error: function(errorMessage){
                alert(errorMessage);
            }
        });

    }
}

$(document).on("hidden.bs.modal","#modal-add-client-admin",function(){
    $("#contactFormCreerClient")[0].reset();
    $("#creerClientForm")[0].reset();
    $('#tableContact tr:not(:first)').remove();
    $('#listContactAjout').hide();
});

$(document).on("shown.bs.modal","#modal-add-projet-admin",function(){
    //init la selection de client et de projet
    jsRoutes.controllers.AdminController.afficherModalCreerProjetResponsable().ajax({
        success: function(listResponsable){
            var responsablelist = $('#responsableProjet');
            $(listResponsable).each(function(index, user) {
                var list ="";
                list+=('<option value='+user.id+'>'+user.prenom+' '+user.nom+'</option>');
                responsablelist.append(list);
            });
        }
    });
    jsRoutes.controllers.AdminController.afficherModalCreerProjetClient().ajax({
        success: function(listClient){
            var clientlist = $('#client');
            $(listClient).each(function(index, client) {
                var list ="";
                list+=('<option value='+client.id+'>'+client.nom+'</option>');
                clientlist.append(list);
            });
        }
    });
});

$(document).on("hidden.bs.modal","#modal-add-projet-admin",function(){
    $("#addProjectForm")[0].reset();
});

$(document).on("hidden.bs.modal","#modal-add-user",function(){
    $("#creerUserForm")[0].reset();
});

$(document).on('click','#dataTables-admin-projet-body tr td:last-child', function(){
    var parent = $(this).parent('tr');
    var idP = parent.attr('value');

    jsRoutes.controllers.AdminController.afficherModalProjet(idP).ajax({
        success: function(projet){
            $("#modal-projet-admin-nom-projet").empty();
            $("#modal-projet-admin-nom-projet").append(projet.nom);
            $tmpTr = parent;
        }
    });
});
var tmpRowModalClientProjet =  [];
var tmpRowModalClientContact =  [];
var listeNewContact =  [];

$(document).on("hidden.bs.modal","#modal-modif-client",function(){
    var tmpRowModalClientProjet =  [];
    var tmpRowModalClientContact =  [];
    /*TODO : mettre les formulaire a 0 */
});

$(document).on('click','#table-modal-client-projets-body tr td:last-child', function(){
    var parent = $(this).parent('tr');
    var idP = parent.attr('value');
    var size = tmpRowModalClientProjet.length;
    tmpRowModalClientProjet[size] = {};
    tmpRowModalClientProjet[size]["idProjet"] = idP;
    parent.remove();
});


$(document).on('click','#table-modal-client-contacts-body tr td:last-child', function(){
    var parent = $(this).parent('tr');

    if($(this).parent('tr').attr("value")!=" "){
        //contact existant
        var idC =  $(this).parent('tr').attr("value");
        var size = tmpRowModalClientContact.length;
        tmpRowModalClientContact[size] = {};
        tmpRowModalClientContact[size]["idContact"] = idC;
    }else{
        //contact non existant, a enlver au niveau de la liste des contact
        var arrayLength = listeNewContact.length;
        for (var i = 0; i < arrayLength; i++) {
            var email = parent.find('td').eq(2).text();
            if(listeNewContact[i]["email"] === email){
                listeNewContact.splice(i, 1);
            }
        }
    }
    parent.remove();
});


/* Afficher les Clients archivés */
function clientsArchived(){
    if($('#checkBoxClientsArchived').is(":checked")) {
        $('.client-archived').show();
    } else {
        $('.client-archived').hide();
    }
}



/* Afficher les projets terminés dans l'onglet projet  */
function projetTDBTermine(){
    if($('#checkbox-tdb-rp-projets-termines').is(":checked")) {
        $('.projet-finished').show();
    } else {
        $('.projet-finished').hide();
    }
}




/* Afficher les projets et taches terminés dans l'onglet tache  */
function projetTacheTDBTermine(){


    if($('#checkbox-tdb-collab-projets-termines').is(":checked")){
        $('.projet-finished').show();
    }
    else{
        $('.projet-finished').hide();
    }



    if($('#checkbox-tdb-collab-taches-termines').is(":checked")){
        $('.tache-finished').show();
    }
    else{
        $('.tache-finished').hide();
    }

    // transforme en et
    var result = "";

    if($('#checkbox-tdb-taches-critiques').is(":checked")){
        result+= '.tache-critique';
        //$('.table-center').hide();
        //$('.tache-critique').show();
    }


    if($('#checkbox-tdb-taches-indisponibles').is(":checked")){
        result+= '.tache-indisponible';
        //$('.table-center').hide();
        //$('.tache-indisponible').show();
    }


    if($('#checkbox-tdb-taches-semaine-pro').is(":checked")){
        result+='.tache-commence-semaine-prochaine';
        //$('.table-center').hide();
        //$('.tache-commence-semaine-prochaine').show();
    }

    if($('#checkbox-tdb-taches-semaine-pro').is(":checked")){
        result+= '.tache-commence-semaine-prochaine';
        //$('.table-center').hide();
        //$('.tache-commence-semaine-prochaine').show();
    }

    if($('#checkbox-tdb-taches-moins-10j').is(":checked")){
        result+= '.tache-terminee-dans-moins-10-j';
        //$('.table-center').hide();
        //$('.tache-terminee-dans-moins-10-j').show();
    }


    if($('#checkbox-tdb-taches-retardees').is(":checked")){
        result+= '.tache-retardee';
        //$('.table-center').hide();
        //$('.tache-retardee').show();
    }

    if(result.length > 0){
        $('.table-center').hide();
        console.log("result = "+result);
        $(result).show();
    }
    else{
        //$('.table-center').show();  // TODO MODIFIER EN FONCTION DES CHECKBOX
    }



}



function filtreTDBproj(){
    if($('#checkbox-tdb-rp-projets-termines').is(":checked")){
        $('.projet-finished').show();
    }
    else{
        $('.projet-finished').hide();
    }




    if($('#checkbox-tdb-projets-retardes').is(":checked")){
        result+= '.projets-retardes';

    }


    if($('#checkbox-tdb-projets-bientot-finis').is(":checked")){
        result+= '.projets-bientot-finis';

    }

    if(result.length > 0){
        $('.table-center').hide();
        console.log("result = "+result);
        $(result).show();
    }
    else{
        //$('.table-center').show();  // TODO MODIFIER EN FONCTION DES CHECKBOX
    }




}






/* Afficher les utilisateurs archivés */
function utilisateursArchived(){
    if($('#checkboxUsersArchived').is(":checked")) {
        $('.user-archived').show();
    } else {
        $('.user-archived').hide();
    }
}

function reverse(string){
    if(string===null){
        return "";
    }else{
        var res =  string.split('/');
        var final = res[2] + '/' + res[1] + '/' + res[0];
        return final;
    }

}

function verif(string){
    if(string === null){
        return "";
    }else{
        return string;
    }
}




//TODO : changer pour la partie consommee
var checkBoxProjetTermine = '#checkbox-projet-admin-projets-termines';
var checkBoxProjetArchive = '#checkbox-projet-admin-projets-archives';
function projetTermines(){
    if($(checkBoxProjetTermine).is(":checked") && $(checkBoxProjetArchive).is(":checked")) {
        $('.projet-archived-finished').show();
        $('.projet-archived').show();
        $('.projet-finished').show();
    }
    else if($(checkBoxProjetTermine).is(":checked"))
    {
        $('.projet-archived-finished').hide();
        $('.projet-finished').show();
    }
    else {
        $('.projet-archived-finished').hide();
        $('.projet-finished').hide();
    }
}



function projetArchives(){
    if($(checkBoxProjetArchive).is(":checked") && $(checkBoxProjetTermine).is(":checked")) {
        $('.projet-archived-finished').show();
        $('.projet-archived').show();
        $('.projet-finished').show();
    }
    else if($(checkBoxProjetArchive).is(":checked"))
    {
        $('.projet-archived-finished').hide();
        $('.projet-archived').show();
    }
    else {
        $('.projet-archived-finished').hide();
        $('.projet-archived').hide();
    }
}

$(document).on("click","#exporter-client", function(event){
    window.open("@routes.ClientController.getClientsAsCSV");
});



//####################################################################
//                         DRAFT PARSING
//####################################################################


function parseDraft(idProjet){
    function ajoutTacheFille(tacheMere,tache){
        tacheMere["childrens"].push(tache);
    }

    function creerTache(tacheId,index,depth){
        var tache={};
        tache["index"]=index;
        tache["depth"]=depth;
        tache["id"]=tacheId;
        tache["childrens"]=new Array();
        return tache;
    }

    var taches = {};
    taches["projectId"] = idProjet;
    taches["taches"] = new Array();

    var processNodes = function(currentElement, depth, taches, parent,index) {
        var currentTache;
        if($(currentElement).is("li")){
            currentTache=creerTache($(currentElement).attr('data-id'),index,depth);
            console.log("depth: "+depth);
            if(depth==0){
                taches["taches"].push(currentTache);
            }
            else{
                ajoutTacheFille(parent,currentTache);
            }

            console.log(Array(depth+1).join("--")+" "+$(currentElement).attr('data-id'));
        }

        var indexChild=0;
        if($(currentElement).children().size()==2 && $(currentElement).children().eq(1).is("ol")){

            $(currentElement).children().eq(1).children().each(function unFunction(element){
                depth=depth+1;
                processNodes($(this),depth, taches, currentTache,indexChild++);
            });
        }
        depth=depth-indexChild-1;
    }


    var depth =0;
    var indexChild=0;
    $("#table_taches_"+idProjet).children().each (function processNodesTmp()
    {
        processNodes(this, depth, taches, null,indexChild++);

    });
    var json = JSON.stringify(taches);
    console.log(json);
    return json;
}

//####################################################################

//######### Modifier projet ##########


