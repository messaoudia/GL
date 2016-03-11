// Message de traduction map
var map = new Object(); // or var map = {};

jsRoutes.controllers.Application.messagesMap().ajax({
    success: function (data) {
        map = data;
    },
    error: function (errorMessage) {
        console.error(errorMessage);
    }
})

var messages = function (key) {
    return map[key];
}

// ============= DO NOT TOUCH ==================

function hideSideBarProjet() {
    $('#col-sidebar-liste-projet').hide();
    $('#afficheListeProjet').css("width", "25px");
    $(".col-consulterProjet").removeClass("col-md-10");
    $(".col-consulterProjet").addClass("col-md-12");
    $("#icon-show-liste-projet").removeClass("fa-outdent");
    $("#icon-show-liste-projet").addClass("fa-indent");
    $('.liste-projet').css('height', "100%");
    height = $('.liste-projet').css('height');
    height = parseInt(height);
    height -= 150;
    $('.liste-projet').css('height', height);
    $('.liste-projet-client').css('height', "100%");
    height = $('.liste-projet-client').css('height');
    height = parseInt(height);
    height -= 200;
    $('.liste-projet-client').css('height', height);

}
function showSideBarProjet() {
    $('#col-sidebar-liste-projet').show();
    $('#afficheListeProjet').css("width", "170px");
    $(".col-consulterProjet").removeClass("col-md-12");
    $(".col-consulterProjet").addClass("col-md-10");
    $("#icon-show-liste-projet").removeClass("fa-indent");
    $("#icon-show-liste-projet").addClass("fa-outdent");
    $('.liste-projet').css('height', "100%");
    height = $('.liste-projet').css('height');
    height = parseInt(height);
    height -= 150;
    $('.liste-projet').css('height', height);
    $('.liste-projet-client').css('height', "100%");
    height = $('.liste-projet-client').css('height');
    height = parseInt(height);
    height -= 200;
    $('.liste-projet-client').css('height', height);

}
$(document).on('click', '#afficheListeProjet', function (event) {
    if ($("#col-sidebar-liste-projet").is(":visible")) {
        hideSideBarProjet();

    }
    else {
        showSideBarProjet();
    }
});

function hideSideBarRetour() {
    $('#col-sidebar-retour').hide();
    $('#afficheRetour').css("width", "25px");
    $("#col-consulterProjet").removeClass("col-md-10");
    $("#col-consulterProjet").addClass("col-md-12");
    $("#icon-show-liste-projet").removeClass("fa-outdent");
    $("#icon-show-liste-projet").addClass("fa-indent");
}
function showSideBarRetour() {
    $('#col-sidebar-retour').show();
    $('#afficheRetour').css("width", "170px");
    $("#col-consulterProjet").removeClass("col-md-12");
    $("#col-consulterProjet").addClass("col-md-10");
    $("#icon-show-liste-projet").removeClass("fa-indent");
    $("#icon-show-liste-projet").addClass("fa-outdent");
}


$(document).on('click', '#afficheRetour', function (event) {
    if ($("#col-sidebar-retour").is(":visible")) {
        hideSideBarRetour();
    }
    else {
        showSideBarRetour();
    }
});


var changeEtatNotifLu = function (idUser, idNotif) {
    jsRoutes.controllers.NotificationController.clickNotificationsLues(idUser, idNotif).ajax({
        success: function (nbNotifNonLues) {
            $('#notif-' + idNotif).removeClass('non-lu');
            $('#notif-' + idNotif).addClass('lu');
            if ($('#notif-' + idNotif).next().is('tr.footable-row-detail')) {
                //$('#notif-etatLecture-' + idNotif).html(messages("read"));
                $('#notif-' + idNotif).next().children().first().children().first().children().first().children().eq(1).html(messages("read"));
            }
            else {
                $('#notif-etatLecture-' + idNotif).html(messages("read"));
            }
            $('#nbNotifNonLues-pageNotif').html(nbNotifNonLues);
            $('#nbNotifNonLues-topbar').html(nbNotifNonLues);
        },
        error: function (errorMsg) {

        }
    });

}

var changeModeDraftProjet = function (idProjet) {
    console.log("Je suis la");
    if ($('#checkbox-draft-projet-' + idProjet).is(':checked')) {
        console.log("Je suis checked");
        $('#nestable-projet-' + idProjet).removeClass("dd-nodrag");
        $('.id-tache').hide();
    }
    else {
        console.log("Je suis pas checked");
        var draftParsedAsJson = parseDraft(idProjet);

        $('#nestable-projet-' + idProjet).addClass("dd-nodrag");
        $('.id-tache').show();


        console.log(draftParsedAsJson);
        jsRoutes.controllers.ProjetController.sendDraf().ajax({
            data: draftParsedAsJson,
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                console.log(data);

                // Refresh project view
                jsRoutes.controllers.ProjetController.afficheProjet(idProjet).ajax({
                    //dataType: "json",
                    //contentType: "application/json",
                    success: function (data) {
                        $('#projet-' + idProjet).html(data);
                        $('#client-projet-' + idProjet).html(data);
                        $('#projet-' + idProjet).show();

                    },
                    error: function (errorMessage) {
                        console.error(errorMessage);
                    }
                });
                jsRoutes.controllers.ProjetController.afficheProjetAdmin(idProjet).ajax({
                    //dataType: "json",
                    //contentType: "application/json",
                    success: function (data) {
                        $('#col-consulterProjet').html(data);
                        $('#col-consulterProjet').show();

                    },
                    error: function (errorMessage) {
                        console.error(errorMessage);
                    }
                });

            },
            error: function (errorMessage) {
                $('#modal-draft-projet').modal('show');
                //var errors = $(errorMessage).get("responseJSON").get("errors");

                var errorsHTML = "<table class=\"table table-bordered\">";
                //JSON.stringify(errorMessage.responseJSON.errors;

                errorsHTML += "<thead><tr><th>Error code</th><th>Error message</th></tr></thead>";
                errorsHTML += "<tbody>";
                $.each(errorMessage.responseJSON.errors, function (key, value) {
                    errorsHTML += "<tr><td>" + key + "</td><td>" + value + "</td></tr>";
                    console.error(key + " -> " + value);
                })

                errorsHTML += "</tbody>";

                errorsHTML += "</table>";

                $('#recapitulative-des-erreurs-projet-draft').html(errorsHTML);

            }
        });
    }
}

var changeModeDraftClient = function (idProjet) {
    console.log("Je suis la");
    if ($('#checkbox-draft-client-' + idProjet).is(':checked')) {
        console.log("Je suis checked");
        $('#nestable-client-projet-' + idProjet).removeClass("dd-nodrag");
        $('.id-tache').hide();
    }
    else {
        console.log("Je suis pas checked");
        $('#nestable-client-projet-' + idProjet).addClass("dd-nodrag");
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


function updateTaskNestableCheckbox(id) {
    console.log("updateTaskNestableCheckbox");

    $("#table_taches_"+id+" li").show();

    var idCheckboxT = "#checkbox-taches-terminees" + id;
    var classTacheT = ".tache-terminee";
    var classTacheTI = ".tache-terminee-indisponible";
    var idCheckboxI = "#checkbox-taches-indisponibles" + id;
    var classTacheI = ".tache-indisponible";

    if ($(idCheckboxT).is(":checked") && $(idCheckboxI).is(":checked")) {
        console.log("les 2 sont coche");
        $(classTacheTI).show();
        $(classTacheT).show();
        $(classTacheI).show();
    }
    else {
        $(classTacheTI).hide();
        if ($(idCheckboxT).is(":checked")) {
            $(classTacheT).show();
            console.log("les termine sont affiche");
        }
        else {
            console.log("les termine sont cache");

            $(classTacheT).hide();
        }


        if ($(idCheckboxI).is(":checked")) {
            console.log("les indispo sont affiche");

            $(classTacheI).show();
        }
        else {
            console.log("les indispo sont cache");

            $(classTacheI).hide();
        }
    }

}

function updateSideBarClientArchive(checkbox) {
    if ($(checkbox).is(":checked")) {
        $(".projet-finished-sidebar").show();
        console.log("TODO check si ok : j'affiche projet termine");
    }
    else {
        $(".projet-finished-sidebar").hide();
        console.log("TODO check si ok : je cache projet termine");

    }
}

$(document).on('click', '.createSubTask', function (event) {
    var btn = $(this);
    console.log("creer sous tache de " + btn.attr("data"));
    $('#formModifierTacheC').validate().resetForm();
    $('#formModifierTacheC').trigger("reset");
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));

    remplirFormulaireCreationTache(btn,true);
    $('#errorCreerTache').hide();

    $('#btn-valider-modifierTacheC').attr("data", btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick", "creerSousTache(this); return false;");
});

var creerSousTache = function (btn) {
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);

    if (dataToSend == -1) {

    } else {
        jsRoutes.controllers.TacheController.creerSousTache(idTacheSelect).ajax({
            data: dataToSend,
            success: function (data) {

                $('#errorCreerTache').hide();
                $('#modal-tache-creer').modal('toggle');

                //Refresh project table
                refreshProjectTable(idTacheSelect);
            },
            error: function (errorMessage) {
                console.log("main.scala > creerSousTache => error");
                console.log("-----------> " + errorMessage)
                $('#errorCreerTache').show();
            }
        });
    }
}

$(document).on('click', '.createTaskHaut', function (event) {
    var btn = $(this);
    console.log("creer tache haut de " + btn.attr("data"));

    $('#formModifierTacheC').validate().resetForm();
    $('#formModifierTacheC').trigger("reset");
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));

    remplirFormulaireCreationTache(btn,false);
    $('#errorCreerTache').hide();
    $('#btn-valider-modifierTacheC').attr("data", btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick", "creerTacheHaut(this); return false;");
});


$(document).on('click', '.createTaskFirst', function (event) {
    var btn = $(this);
    $('#formModifierTacheC').validate().resetForm();
    $('#formModifierTacheC').trigger("reset");
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));

    remplirFormulaireCreationTacheFirst(btn);
    $('#errorCreerTache').hide();
    //$('#btn-valider-modifierTacheC').attr("data", btn.attr("data"));
    var val = btn.attr("value");
    $('#btn-valider-modifierTacheC').attr("value", val);
    $('#btn-valider-modifierTacheC').attr("onclick", "creerTache(this); return false;");
});


var creerTache = function (btn) {
    var dataToSend = creerDataFormulaireCreationTache(btn);
    var value = $(btn).attr("value");
    if (dataToSend == -1) {
    } else {
        jsRoutes.controllers.TacheController.creerTache(value).ajax({
            data: dataToSend,
            success: function (data) {
                console.log("main.scala : success");
                $('#errorCreerTache').hide();
                $('#modal-tache-creer').modal('toggle');

                //Refresh project table
                refreshProjectTable(data.id);
            },
            error: function (errorMessage) {
                console.log("main.scala > creerSousTache => error");
                console.log("-----------> " + errorMessage)
                $('#errorCreerTache').show();
            }
        });
    }
}

var remplirFormulaireCreationTacheFirst = function (btn) {
    //FIXME Dates limites
    var value = btn.attr("value");
    jsRoutes.controllers.DashboardController.getAllInterlocuteur(value).ajax({
        success: function (interlocuteursClient) {
            var listCreer = "";
            $(interlocuteursClient).each(function (i, interlocuteur) {
                listCreer += '<li><div class="checkbox checkbox-success checkbox-dropdown">';
                listCreer += '<input id="checkbox-interlocuteurC-' + i + '" type="checkbox" value="' + interlocuteur.id + '">';
                listCreer += '<label for="checkbox-interlocuteurC-' + i + '">';
                listCreer += interlocuteur.nom + ' ' + interlocuteur.prenom + '</label></div></li>';
            });

            $('#interlocuteurs-modifierC').html(listCreer);

        },
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });

    //Responsable de tache
    jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
        success: function (utilisateurs) {
            var list = "";
            $(utilisateurs).each(function (index, u) {
                list += '<option value="' + u.id + '">' + u.nom + ' ' + u.prenom + '</option>';
            });

            $('#responsableTacheModifierC').html(list);
        },
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}


var creerTacheHaut = function (btn) {
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);

    if (dataToSend == -1) {

    } else {
        console.log("main.scala : appel du controlleur creerTacheHaut");
        jsRoutes.controllers.TacheController.creerTacheHaut(idTacheSelect).ajax({
            data: dataToSend,
            success: function (data) {
                console.log("main.scala : success");

                $('#errorCreerTache').hide();
                $('#modal-tache-creer').modal('toggle');

                //Refresh project table
                refreshProjectTable(idTacheSelect);
            },
            error: function (errorMessage) {
                console.log("main.scala > creerTacheHaut => error");
                console.log("-----------> " + errorMessage)
                $('#errorCreerTache').show();
            }
        });
    }
}

$(document).on('click', '.createTaskBas', function (event) {
    var btn = $(this);

    console.log("creer tache bas de " + btn.attr("data"));
    $('#formModifierTacheC').validate().resetForm();
    $('#formModifierTacheC').trigger("reset");
    $('#nomProjet-modifier-tdbC').html(btn.attr("projet"));
    $('#nomClient-modifier-tdbC').html(btn.attr("client"));

    remplirFormulaireCreationTache(btn,false);
    $('#errorCreerTache').hide();
    $('#btn-valider-modifierTacheC').attr("data", btn.attr("data"));
    $('#btn-valider-modifierTacheC').attr("onclick", "creerTacheBas(this); return false;");
});

var creerTacheBas = function (btn) {
    var idTacheSelect = $(btn).attr("data");
    var dataToSend = creerDataFormulaireCreationTache(btn);

    if (dataToSend == -1) {

    } else {
        console.log("main.scala : appel du controlleur creerTacheBas");
        jsRoutes.controllers.TacheController.creerTacheBas(idTacheSelect).ajax({
            data: dataToSend,
            success: function (data) {
                console.log("main.scala : success");

                $('#errorCreerTache').hide();
                $('#modal-tache-creer').modal('toggle');

                //Refresh project table
                refreshProjectTable(idTacheSelect);
            },
            error: function (errorMessage) {
                console.log("main.scala > creerTacheBas => error");
                console.log("-----------> " + errorMessage)
                $('#errorCreerTache').show();

            }
        });
    }
}

var creerDataFormulaireCreationTache = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;

    if ($(form).valid()) {
        var serialize = $(form).serialize();
        console.log(serialize);

        //PREDECESSEUR
        var idPredecesseur = "";
        if ($('#form-tache-predecesseurC').select2().val() != null) {
            idPredecesseur = $('#form-tache-predecesseurC').select2().val()[0];
            console.log("idPredecesseur" + idPredecesseur);
        }

        var tabSuccesseurs = [];
        //SUCCESSEUR
        $("#form-tache-successeurC option").each(function () {
            if ($(this).is(':selected')) {
                console.log("selected : " + $(this).val());
                tabSuccesseurs.push($(this).val());
            }
        });

        //RESPONSABLE DE TACHE
        var idResponsableTache = $('#responsableTacheModifierC').select2().val()[0];
        console.log("idReponsableTache" + idResponsableTache);

        //INTERLOCUTEURS EXTERNES
        var nbInterlocuteurs = $("#interlocuteurs-modifierC li").length;
        var tabInterlocuteurs = [];

        for (i = 0; i < nbInterlocuteurs; i++) {
            if ($("#checkbox-interlocuteurC-" + i).is(':checked')) {
                console.log("checked : " + $("#checkbox-interlocuteurC-" + i).attr('value'));
                tabInterlocuteurs.push($("#checkbox-interlocuteurC-" + i).attr('value'));
            }
        }
        //alert(idPredecesseur);
        var dataToSend = serialize + "&predecesseurC=" + idPredecesseur;
        dataToSend += "&successeursC=";

        for (var i = 0; i < tabSuccesseurs.length; i++) {
            dataToSend += tabSuccesseurs[i] + ",";
        }

        dataToSend += "&responsableC=" + idResponsableTache;

        dataToSend += "&interlocuteursC=";

        for (var i = 0; i < tabInterlocuteurs.length; i++) {
            dataToSend += tabInterlocuteurs[i] + ",";
        }


        return dataToSend;
    } else {
        return -1;
    }
}

var refreshProjectTable = function (idTacheSelect) {

    jsRoutes.controllers.TacheController.getTacheById(idTacheSelect).ajax({
        success: function (tache) {
            var projetId = tache.projet.id;
            refreshProjectTableByIdProject(projetId);
        },
        error: function (errorMessage) {
            console.log(errorMessage);
        }
    });
}

var refreshProjectTableByIdProject = function (projetId) {
    // Refresh project view
    jsRoutes.controllers.ProjetController.afficheProjet(projetId).ajax({
        success: function (data) {
            $('#projet-' + projetId).html(data);
            $('#client-projet-' + projetId).html(data);
            $('#projet-' + projetId).show();
            console.log("AfficheProjet OK : " + projetId);
        },
        error: function (errorMessage) {
            console.log(errorMessage);
            console.log("AfficheProjet KO : " + projetId);
        }
    });
    jsRoutes.controllers.ProjetController.afficheProjetAdmin(projetId).ajax({
        success: function (data) {
            $('#col-consulterProjet').html(data);
            $('#col-consulterProjet').show();
            console.log("AfficheProjet OK : " + projetId);
        },
        error: function (errorMessage) {
            console.log(errorMessage);
            console.log("AfficheProjet KO : " + projetId);
        }
    });
}

var remplirFormulaireCreationTache = function (btn,isSubTask) {
    var jsonTache = "";
    //FIXME Dates limites
    jsRoutes.controllers.TacheController.getTacheById(btn.attr("data")).ajax({
        success: function (tache) {
            jsonTache = tache;
            //alert(tache);
            var dateDebut = tache.dateDebut;
            var dateFinTard = tache.dateFinTard;
            /*
            $('#datepicker_date_debutC .input-group.date').datepicker('option', {
                minDate: new Date(dateDebut.split("/")[2], dateDebut.split("/")[1], dateDebut.split("/")[0]),
                maxDate: new Date(dateFinTard.split("/")[2], dateFinTard.split("/")[1], dateFinTard.split("/")[0]),
            });*/
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
                success: function (interlocuteursClient) {
                    var listCreer = "";
                    $(interlocuteursClient).each(function (i, interlocuteur) {
                        listCreer += '<li><div class="checkbox checkbox-success checkbox-dropdown">';
                        listCreer += '<input id="checkbox-interlocuteurC-' + i + '" type="checkbox" value="' + interlocuteur.id + '">';
                        listCreer += '<label for="checkbox-interlocuteurC-' + i + '">';
                        listCreer += interlocuteur.nom + ' ' + interlocuteur.prenom + '</label></div></li>';
                    });

                    $('#interlocuteurs-modifierC').html(listCreer);

                },
                error: function (errorMessage) {
                    console.log(errorMessage);
                    alert(errorMessage);
                }
            });

            if(isSubTask == true) {
                //Predecesseurs possible
                jsRoutes.controllers.DashboardController.getAllPredecesseursPossible(tache.id).ajax({
                    success: function (taches) {
                        //console.log(taches);
                        var list = "";

                        $(taches).each(function (index, t) {
                            if (t.id == tache.predecesseurId) {
                                list += '<option value="' + t.id + '" selected>' + t.idTache + ' - ' + t.nom + '</option>';
                            }
                            else {
                                list += '<option value="' + t.id + '">' + t.idTache + ' - ' + t.nom + '</option>';
                            }
                        });

                        $('#form-tache-predecesseurC').html(list);
                    },
                    error: function (errorMessage) {
                        console.log(errorMessage);
                        alert(errorMessage);
                    }
                });

                //Successeurs possible
                jsRoutes.controllers.DashboardController.getAllSucesseursPossible(tache.id).ajax({
                    success: function (taches) {
                        //console.log(taches);
                        var list = "";

                        $(taches).each(function (index, t) {
                            var isSuccesseur = false;
                            $(tache.successeurs).each(function (index, s) {
                                if (t.id == s.id) {
                                    isSuccesseur = true;
                                    return;
                                }
                            });
                            if (isSuccesseur) {
                                list += '<option value="' + t.id + '" selected>' + t.idTache + ' - ' + t.nom + '</option>';
                            } else {
                                list += '<option value="' + t.id + '">' + t.idTache + ' - ' + t.nom + '</option>';
                            }
                        });

                        $('#form-tache-successeurC').html(list);
                    },
                    error: function (errorMessage) {
                        console.log(errorMessage);
                        alert(errorMessage);
                    }
                });

            }else{
                //Predecesseurs et Successeurs possible
                jsRoutes.controllers.DashboardController.getAllTasks(tache.id).ajax({
                    success: function (taches) {
                        //console.log(taches);
                        var list = "";

                        $(taches).each(function (index, t) {
                            list += '<option value="' + t.id + '">' + t.idTache + ' - ' + t.nom + '</option>';
                        });

                        $('#form-tache-predecesseurC').html(list);
                        $('#form-tache-successeurC').html(list);
                    },
                    error: function (errorMessage) {
                        console.log(errorMessage);
                        alert(errorMessage);
                    }
                });
            }
            //Responsable de tache
            jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
                success: function (utilisateurs) {
                    var list = "";
                    $(utilisateurs).each(function (index, u) {
                        list += '<option value="' + u.id + '">' + u.nom + ' ' + u.prenom + '</option>';
                    });

                    $('#responsableTacheModifierC').html(list);
                },
                error: function (errorMessage) {
                    console.log(errorMessage);
                    alert(errorMessage);
                }
            });
        }
    });

}

$(document).on('click', '#interlocuteurs-modifier', function (event) {
    event.stopPropagation();
});

$(document).on('click', '#interlocuteurs-modifierC', function (event) {
    event.stopPropagation();
});

$(document).on('click', '#dropdown-onglet-projet', function (event) {
    event.stopPropagation();
});

$(document).on('click', '#dropdown-onglet-tache', function (event) {
    event.stopPropagation();
});

$(document).on('click', '#dataTables-admin-user tr td:not(:last-child)', function () {
    var id = $(this).parent('tr').attr('value');
    userRow = $(this).parent('tr');
    console.log("id.on = " + id);
    jsRoutes.controllers.AdminController.afficherModalUtilisateur(id).ajax({
        success: function (utilisateur) {
            //console.log(utilisateur);
            /* fill modal values*/
            if (utilisateur.archive) {
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
            if (true) {
                // si le bouton a deja la classe ca sert a rien de changer
                if (!$("#btnAdminNonModifier").hasClass("btn-active")) {
                    $("#btnAdminOuiModifier").removeClass("btn-active")
                    $("#btnAdminNonModifier").addClass("btn-active");
                }
            }
            else {
                if (!$("#btnAdminOuiModifier").hasClass("btn-active")) {
                    $("#btnAdminNonModifier").removeClass("btn-active")
                    $("#btnAdminOuiModifier").addClass("btn-active");
                }
            }
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
            console.log(errorMessage);
        }
    });
});

$(document).on('click', '#dataTables-admin-projet tr td:not(:last-child)', function () {
    var $valueTr = $(this).parent('tr').attr('value');
    jsRoutes.controllers.AdminController.afficherAdminProjetsSelect($valueTr).ajax({
        success: function (html) {
            var result = $('#refresh', html);
            $('#refresh').empty().html(result);
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
});
$(document).on('click', '#dataTables-admin-client-body tr td:last-child', function () {

    var parent = $(this).parent('tr');
    var idC = parent.attr('value');
    jsRoutes.controllers.AdminController.afficherModalClient(idC).ajax({
        success: function (client) {
            $("#delete-project-name").empty();
            $("#delete-project-name").append(client.nom);
            $tmpTrAdminClient = parent;
        }
    });
});

$(document).on('click', '#dataTables-admin-user tr td:last-child', function () {
    $tmpTrAdminUser = $(this).parent('tr');

    var idU = $tmpTrAdminUser.attr('value');
    jsRoutes.controllers.AdminController.afficherModalUtilisateur(idU).ajax({
        success: function (u) {
            $("#delete-utilisateur-name").empty();
            $("#delete-utilisateur-name").append(" " + u.prenom + " " + u.nom + " (" + u.email + ")");
            $("#delete-utilisateur-name-confirm").empty();
            $("#delete-utilisateur-name-confirm").append(" " + u.prenom + " " + u.nom + " (" + u.email + ")");
            jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
                success: function (utilisateurs) {
                    console.log(utilisateurs);
                    jsRoutes.controllers.UtilisateurController.listProjetsUtilisateur(idU).ajax({
                        success: function (listProjets) {
                            console.log(listProjets);
                            //listProjets
                            var projetTableBody = $('#table-modal-suppr-user-projet-body');
                            projetTableBody.empty();

                            var p = "";
                            if (listProjets.length != 0) {
                                $(listProjets).each(function (index, projet) {
                                    p += ('<tr value="' + projet.id + '">');
                                    p += ('<td>' + projet.nom + '</td>');
                                    if (utilisateurs.length != 0) {
                                        p += ('<td><select class="form-control select2-respo-projet" style="width:100%;" multiple="single">');
                                        $(utilisateurs).each(function (index, u) {
                                            // lister tous les utilisaturs en cours sauf l'user courant
                                            if (u.id != idU) {
                                                p += ('<option value="' + u.id + '">' + u.nom + ' ' + u.prenom + ' (' + u.email + ')</option>');
                                            }//console.log(u.nom);
                                        });
                                        p += ('</select></td>');
                                    }
                                    p += ('</tr>');

                                });
                                projetTableBody.append(p);
                                p = "";
                            }
                        }
                    });

                    jsRoutes.controllers.UtilisateurController.listTachesUtilisateur(idU).ajax({
                        success: function (listTaches) {
                            console.log(listTaches);
                            var tacheeBody = $('#table-modal-suppr-user-tache-body');
                            tacheeBody.empty();

                            var p = "";
                            if (listTaches.length != 0) {
                                $(listTaches).each(function (index, tache) {
                                    p += ('<tr value="' + tache.id + '">');
                                    p += ('<td>' + tache.nom + '</td>');
                                    p += ('<td>' + tache.projet.nom + '</td>');
                                    if (utilisateurs.length != 0) {
                                        p += ('<td><select class="form-control select2-respo-tache" style="width:100%;" multiple="single">');
                                        $(utilisateurs).each(function (index, u) {
                                            // lister tous les utilisaturs en cours sauf l'user courant
                                            if (u.id != idU) {
                                                p += ('<option value="' + u.id + '">' + u.nom + ' ' + u.prenom + ' (' + u.email + ')</option>');
                                            }//console.log(u.nom);
                                        });
                                        p += ('</select></td>');
                                    }
                                    p += ('</tr>');

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


var d = "";
var modalId;

function modal(client, idC) {
    $("#dataTables-admin-client").dataTable().fnDestroy();
    if (client.archiver) {
        d = "D";
    }

    $('#formClientName' + d).val(client.nom);
    $('#formClientAdress' + d).val(client.adresseClient.adresse);
    $('#formZipCode' + d).val(client.adresseClient.zipCode);
    $('#formCity' + d).val(client.adresseClient.ville);
    $('#formCountry' + d).val(client.adresseClient.pays);

    $('#client-priority-1' + d).removeClass("btn-active");
    $('#client-priority-2' + d).removeClass("btn-active");
    $('#client-priority-3' + d).removeClass("btn-active");
    $('#client-priority-' + client.priorite + d).addClass("btn-active");

    jsRoutes.controllers.ProjetController.afficherProjetsClient(idC).ajax({
        success: function (listProjets) {
            console.log("sucess -----");
            var projetTableBody = $('#table-modal-client-projets-body' + d);
            projetTableBody.empty();
            console.log(listProjets);
            $("#dataTables-admin-client" + d).dataTable().fnDestroy();
            if (listProjets.length != 0) {
                $(listProjets).each(function (index, projet) {
                    var p = "";
                    p += ('<tr value="' + projet.id + '">');
                    p += ('<td class="first-td">' + projet.nom + '</td>');
                    if (d == "D" || projet.archive == true) {
                        p += ('<td class="td-btn-suppr-disable" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    else {
                        p += ('<td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    p += ('</tr>');

                    projetTableBody.append(p);
                });
            }
        },
        error: function (errorMessage) {
            console.log("error : " + errorMessage)
        }
    });

    jsRoutes.controllers.ContactController.afficherContactsClient(idC).ajax({
        success: function (listContacts) {
            var contactsTableBody = $('#table-modal-client-contacts-body' + d);
            contactsTableBody.empty();
            console.log(listContacts);
            $("#dataTables-admin-client" + d).dataTable().fnDestroy();
            if (listContacts.length != 0) {
                $(listContacts).each(function (index, contact) {
                    var c = "";
                    c += ('<tr value="' + contact.id + '">');
                    c += ('<td class="first-td">' + contact.nom + '</td>');
                    c += ('<td class="first-td">' + contact.prenom + '</td>');
                    c += ('<td style="display:none;">' + contact.email + '</td>');
                    c += ('<td style="display:none;">' + contact.telephone + '</td>');
                    if (d == "D" || contact.archive == true) {
                        c += ('<td class="td-btn-suppr-disable" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }
                    else {
                        c += ('<td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                    }

                    c += ('</tr>');

                    contactsTableBody.append(c);
                });
            }
        },
        error: function (errorMessage) {
            console.log("error : " + errorMessage)
        }
    });

}
$(document).on('click', '#dataTables-admin-client tr td:not(:last-child)', function () {
    var idC = $(this).parent('tr').attr('value');
    clientRow = $(this).parent('tr');
    jsRoutes.controllers.AdminController.afficherModalClient(idC).ajax({
        success: function (client) {
            //console.log(client);
            console.log("client : " + client);
            modal(client, idC);
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
});
//dataTables-admin-client
var supprimerProjet = function () {
    var $value = $tmpTr.attr('value');
    console.log($value);
    jsRoutes.controllers.AdminController.supprimerProjet($value).ajax({
        success: function (projetArchive) {
            //console.log("Archie JSON : " + JSON.stringify(projetArchive));
            if (projetArchive.avancementGlobal == 100) {
                $tmpTr.removeClass("projet-finished");
                $tmpTr.addClass("projet-archived-finished");

                if (!$(checkBoxProjetTermine).is(":checked") || !$(checkBoxProjetArchive).is(":checked")) {
                    $tmpTr.hide();
                }
            }
            else {
                $tmpTr.addClass("projet-archived");
            }
        },
        error: function (errorMessage, codeerror) {
            alert(errorMessage);
            alert(codeerror);
        }
    });
}


var activerOuDesactiverNotification = function (idTache, idUser) {

    jsRoutes.controllers.NotificationController.activerOuDesactiverNotificationTache(idTache, idUser).ajax({
        success: function () {
            var iconeToChange = $('#notif-icon-tache-' + idTache);
            if (iconeToChange.hasClass('fa-bell')) {
                iconeToChange.removeClass('fa-bell');
                iconeToChange.addClass('fa-bell-slash-o');
            }
            else if (iconeToChange.hasClass('fa-bell-slash-o')) {
                iconeToChange.removeClass('fa-bell-slash-o');
                iconeToChange.addClass('fa-bell');
            }

        },
        //Case we have a problem
        error: function (errorMessage) {
        }
    });
}

var selectUtilisateursASuivre = function (idUserConnecte) {
    var listUtilisateurs = $('#searchContact-select2').val();
    //console.log("List User : " + listUtilisateurs);
    if (listUtilisateurs == null) {
        listUtilisateurs = "";
    }
    jsRoutes.controllers.UtilisateurController.modifierUtilisateursASuivre(idUserConnecte, listUtilisateurs).ajax();
}

var activeOuDesactiveNotifMesActions = function (idUserConnecte) {
    var isChecked = $('#checkbox-changes').is(':checked');
    console.log("activeOuDesactiveNotifMesActions : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationMesActions(idUserConnecte, isChecked).ajax();
}

var activeOuDesactiveNotifTachesPresqueTerminees = function (idUserConnecte) {
    var isChecked = $('#checkbox-tasks-almost-finish').is(':checked');
    console.log("activeOuDesactiveNotifTachesPresqueTerminees : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationTachesPresqueFinies(idUserConnecte, isChecked).ajax();
}

var activeOuDesactiveNotifTachesRetardees = function (idUserConnecte) {
    var isChecked = $('#checkbox-tasks-late').is(':checked');
    console.log("activeOuDesactiveNotifTachesRetardees : " + isChecked);
    jsRoutes.controllers.UtilisateurController.modifierNotificationTachesRetardees(idUserConnecte, isChecked).ajax();
}

var saveBlocNote = function (idUser) {
    console.log("Bloc note : " + $('#bloc-notes-tdb').val());
    jsRoutes.controllers.DashboardController.saveBlocNote(idUser, $('#bloc-notes-tdb').val()).ajax();
}

$('#checkbox-notif-all-selected').click(function () {
    if ($('#checkbox-notif-all-selected').is(':checked')) {
        $("div.checkbox-notif input[type=checkbox]").each(function () {
            $(this).attr('checked', true);
        });
    }
    else {
        $("div.checkbox-notif input[type=checkbox]").each(function () {
            $(this).attr('checked', false);
        });
    }
});


var clickNotificationsSupprimer = function (idUser) {
    var listIdNotif = "";
    $("div.checkbox-notif input:checked").each(function () {
        listIdNotif += $(this).attr("name") + ",";
    });
    if (listIdNotif.length > 0) {
        listIdNotif = listIdNotif.substring(0, listIdNotif.length - 1);
        console.log(listIdNotif);
        jsRoutes.controllers.NotificationController.clickNotificationsSupprimer(idUser, listIdNotif).ajax({
            success: function (nbNotifNonLues) {
                var listIdNotifSplit = listIdNotif.split(",");
                for (var i = 0; i < listIdNotifSplit.length; i++) {
                    var idNotif = listIdNotifSplit[i];
                    if ($('#notif-' + idNotif).next().is('tr.footable-row-detail')) {
                        $('#notif-' + idNotif).next().remove();
                    }
                    $('#notif-' + idNotif).remove();
                    $('#nbNotifNonLues-pageNotif').html(nbNotifNonLues);
                    $('#nbNotifNonLues-topbar').html(nbNotifNonLues);
                }
            },
            error: function () {
            }
        });
    }
}

var changePassword = function (idUser) {
    var previousPassword = $('#previousPassword').val();
    var newPassword = $('#newPassword').val();
    var confirmNewPassword = $('#newPasswordConfirm').val();
    jsRoutes.controllers.UtilisateurController.changePassword(idUser, previousPassword, newPassword, confirmNewPassword).ajax({
        success: function () {
            console.log("Modification password ok");
            $('#previousPassword').val('');
            $('#newPassword').val('');
            $('#newPasswordConfirm').val('');
            $('#errorMessagePreviousPassword').hide();
            $('#errorMessageNewPassword').hide();
            $('#errorMessageNewPasswordConfirm').hide();
            $("#successChangePassword").show();
            setTimeout(function () {
                $("#successChangePassword").hide();
            }, 2000);
        },
        error: function (errorMessage) {
            console.log("Modification password ko");
            console.log(errorMessage.responseJSON);
            console.log(errorMessage.responseJSON.previousPasswordCorrect);
            console.log(errorMessage.responseJSON.newPasswordCorrect);
            console.log(errorMessage.responseJSON.newPasswordCorrect);

            if (errorMessage.responseJSON.previousPasswordCorrect == false) {
                $('#errorMessagePreviousPassword').show();
            } else {
                $('#errorMessagePreviousPassword').hide();
            }
            if (errorMessage.responseJSON.newPasswordCorrect == false) {
                $('#errorMessageNewPassword').show();
            } else {
                $('#errorMessageNewPassword').hide();
            }
            if (errorMessage.responseJSON.confirmNewPasswordCorrect == false) {
                $('#errorMessageNewPasswordConfirm').show();
            } else {
                $('#errorMessageNewPasswordConfirm').hide();
            }
        }
    });
}

var activeModificationProjetDansProjet = function (idProjet) {
    jQuery.fx.off = true;
    $("#div-consulterProjet-" + idProjet).hide();
    $("#div-modifierProjet-" + idProjet).show();
    jQuery.fx.off = false;
}

var cancelProjetAdmin = function (idProjet) {
    jQuery.fx.off = true;
    $("#div-modifierProjet-admin").hide();
    $("#div-consulterProjet-admin").show();
    jQuery.fx.off = false;
    jsRoutes.controllers.ProjetController.infoProjet(idProjet).ajax({
        success: function (data) {
            $("#div-modifierProjet-admin").find('input[name=projet]').val(data.nom);

            $("#div-modifierProjet-admin").find('textarea[name=description]').html(data.description);
            //bouton priorite

            $("#projet-modifierAdmin-btn .btn").removeClass('btn-active');
            if (data.priorite == 1) {
                $("#first-admin-projet").addClass('btn-active');
            } else if (data.priorite == 2) {
                $("#second-admin-projet").addClass('btn-active');
            } else {
                $("#third-admin-projet").addClass('btn-active');
            }

            $("#responsableProjet option").removeAttr("selected");
            $("#responsableProjet option[value=" + data.responsableProjet.id + "]").prop("selected", "selected");
            $("#client option").removeAttr("selected");
            $("#client option[value=" + data.client.id + "]").prop("selected", "selected")
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });

}

var desactiveModificationProjetDansProjet = function (idProjet) {
    jQuery.fx.off = true;
    $("#div-modifierProjet-" + idProjet).hide();
    $("#div-consulterProjet-" + idProjet).show();
    jQuery.fx.off = false;
    //mis a jour des champs en fonction du projet
    jsRoutes.controllers.ProjetController.infoProjet(idProjet).ajax({
        success: function (data) {
            $("#div-modifierProjet-" + idProjet).find('input[name=projet]').val(data.nom);
            $("#div-modifierProjet-" + idProjet).find('textarea[name=description]').html(data.description);
            //bouton priorite
            $("#projet-modifier-btn-" + idProjet + " .btn").removeClass('btn-active');
            if (data.priorite == 1) {
                $("#first-" + idProjet).addClass('btn-active');
            } else if (data.priorite == 2) {
                $("#second-" + idProjet).addClass('btn-active');
            } else {
                $("#third-" + idProjet).addClass('btn-active');
            }
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}

var activeModificationProjetDansClient = function (idProjet) {
    jQuery.fx.off = true;
    $("#div-consulterProjet-client-" + idProjet).hide();
    $("#div-modifierProjet-client-" + idProjet).show();
    jQuery.fx.off = false;
}

var desactiveModificationProjetDansClient = function (idProjet) {
    jQuery.fx.off = true;
    $("#div-modifierProjet-client-" + idProjet).hide();
    $("#div-consulterProjet-client-" + idProjet).show();
    jQuery.fx.off = false;
}

var afficherNotifications = function () {
    //e.preventDefault();
    jsRoutes.controllers.NotificationController.afficherNotifications().ajax({
        success: function (html) {
            var result = $('#refresh', html).html();
            $('#refresh').empty().html(result);

        },
        //Case we have a problem
        error: function (errorMessage) {
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
        success: function (utilisateur) {
            //console.log(utilisateur);
            $("#dataTables-admin-user").dataTable().fnDestroy();
            /* fill modal values*/
            $('.formLastName').val(utilisateur.nom);
            $('.formFirstName').val(utilisateur.prenom);
            $('.formEmail').val(utilisateur.email);
            $('.formTel').val(utilisateur.telephone);
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}


var supprContact = function (td) {
    var tr = $(td).parent('tr');
    tr.remove();
    var rowCount = $('#tableContact tbody tr').length;
    if (rowCount == 0) {
        $('#listContactAjout').hide();
    }
}


var afficherAdminProjets = function () {
    jsRoutes.controllers.AdminController.afficherAdminProjets().ajax({
        success: function (html) {
            var result = $('#refresh', html);
            $('#refresh').empty().html(result);
        },
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}

function notifPopupTache(fa, idTache) {
    //TODO traitement des notifs
    jsRoutes.controllers.NotificationController.hasActiverNotification(idTache).ajax({
        success: function (booleanString) {
            if ($(fa).hasClass('fa-bell-slash')) {
                $(fa).removeClass('fa-bell-slash');
            } else {
                $(fa).removeClass('fa-bell');
            }

            if (booleanString == 'false') {
                $(fa).addClass('fa-bell');
            }
            else {
                $(fa).addClass('fa-bell-slash');
            }
        },
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}

function listContains(list, obj) {
    for (var i in list) {
        if (list[i].email == obj.email) {
            return true;
        }
    }
    return false;
}
var compareJSON = function (obj1, obj2) {
    var ret = {};
    var k = 0;
    for (var i in obj1) {
        if (!listContains(obj2, obj1[i])) {
            ret[k] = obj1[i];
            k++;
        }
    }
    return ret;
};

var updateIndisponibleTache = function () {
    if ($('#btn-indisponibleTache i').hasClass("fa-lock")) {

        var idTache = $('#btn-indisponibleTache').attr("data");
        jsRoutes.controllers.ProjetController.updateTacheToDisponible(idTache).ajax({
            success: function (tache) {
                $('#btn-indisponibleTache i').removeClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");
                $('#btn-indisponibleTache i').addClass("fa-unlock")
                $('#btn-indisponibleTache-modifier i').addClass("fa-unlock");

                $('#formModifierChargeInitiale').removeAttr("disabled");
                $('#formModifierChargeRestante').removeAttr("disabled");
                $('#formModifierChargeConsommee').removeAttr("disabled");
                $("li[data-id="+idTache+"]").removeClass("tache-indisponible");

                updateTaskNestableCheckbox(tache.projet.id);

            },
            error: function (errorMessage) {
                alert(errorMessage);
            }
        });
    }
    else {

        var idTache = $('#btn-indisponibleTache').attr("data");

        jsRoutes.controllers.ProjetController.updateTacheToIndisponible(idTache).ajax({
            success: function (tache) {
                $('#btn-indisponibleTache i').removeClass("fa-unlock");
                $('#btn-indisponibleTache i').addClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-lock");
                console.log("la tache " + $('#btn-indisponibleTache').attr("data") + " devient indisponible");
                $('#formModifierChargeInitiale').attr("disabled", "");
                $('#formModifierChargeRestante').attr("disabled", "");
                $('#formModifierChargeConsommee').attr("disabled", "");
                $("li[data-id="+idTache+"]").addClass("tache-indisponible");

                updateTaskNestableCheckbox(tache.projet.id);

            },
            error: function (errorMessage) {
                alert(errorMessage);
            }
        });

    }
}


var updateIndisponibleTacheModifier = function () {
    if ($('#btn-indisponibleTache-modifier i').hasClass("fa-lock")) {

        var idTache = $('#btn-indisponibleTache-modifier').attr("data");
        jsRoutes.controllers.ProjetController.updateTacheToDisponible(idTache).ajax({
            success: function (tache) {
                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-unlock");
                $('#btn-indisponibleTache i').removeClass("fa-lock");
                $('#btn-indisponibleTache i').addClass("fa-unlock")
                console.log("la tache " + $('#btn-indisponibleTache-modifier').attr("data") + " devient disponible");
                $('#formModifierChargeInitiale').removeAttr("disabled");
                $('#formModifierChargeRestante').removeAttr("disabled");
                $('#formModifierChargeConsommee').removeAttr("disabled");
                $("li[data-id="+idTache+"]").removeClass("tache-indisponible");
                updateTaskNestableCheckbox(tache.projet.id);
            },
            error: function (errorMessage) {
                alert(errorMessage);
            }
        });
    }
    else {

        var idTache = $('#btn-indisponibleTache-modifier').attr("data");

        jsRoutes.controllers.ProjetController.updateTacheToIndisponible(idTache).ajax({
            success: function (tache) {
                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");
                $('#btn-indisponibleTache-modifier i').addClass("fa-lock");
                $('#btn-indisponibleTache i').removeClass("fa-unlock");
                $('#btn-indisponibleTache i').addClass("fa-lock");
                console.log("la tache " + $('#btn-indisponibleTache-modifier').attr("data") + " devient indisponible");
                $('#formModifierChargeInitiale').attr("disabled", "");
                $('#formModifierChargeRestante').attr("disabled", "");
                $('#formModifierChargeConsommee').attr("disabled", "");
                $("li[data-id="+idTache+"]").addClass("tache-indisponible");

                updateTaskNestableCheckbox(tache.projet.id);
            },
            error: function (errorMessage) {
                alert(errorMessage);
            }
        });

    }
}

$(document).on("hidden.bs.modal", "#modal-add-client-admin", function () {
    $("#contactFormCreerClient")[0].reset();
    $("#creerClientForm")[0].reset();
    $('#tableContact tr:not(:first)').remove();
    $('#listContactAjout').hide();
});

$(document).on("shown.bs.modal", "#modal-add-projet-admin", function () {
    //init la selection de client et de projet
    jsRoutes.controllers.AdminController.afficherModalCreerProjetResponsable().ajax({
        success: function (listResponsable) {
            var responsablelist = $('#responsableProjet');
            $(listResponsable).each(function (index, user) {
                var list = "";
                list += ('<option value=' + user.id + '>' + user.prenom + ' ' + user.nom + ' (' + user.email + ') </option>');
                responsablelist.append(list);
            });
        }
    });
    jsRoutes.controllers.AdminController.afficherModalCreerProjetClient().ajax({
        success: function (listClient) {
            var clientlist = $('#client');
            $(listClient).each(function (index, client) {
                var list = "";
                list += ('<option value=' + client.id + '>' + client.nom + '</option>');
                clientlist.append(list);
            });
        }
    });
});

$(document).on("hidden.bs.modal", "#modal-add-projet-admin", function () {
    $("#addProjectForm")[0].reset();
});

$(document).on("hidden.bs.modal", "#modal-add-user", function () {
    $("#creerUserForm")[0].reset();
});

$(document).on('click', '#dataTables-admin-projet-body tr td:last-child', function () {
    var parent = $(this).parent('tr');
    var idP = parent.attr('value');

    jsRoutes.controllers.AdminController.afficherModalProjet(idP).ajax({
        success: function (projet) {
            $("#modal-projet-admin-nom-projet").empty();
            $("#modal-projet-admin-nom-projet").append(projet.nom);
            $tmpTr = parent;
        }
    });
});
var tmpRowModalClientProjet = [];
var tmpRowModalClientContact = [];
var listeNewContact = [];

$(document).on("hidden.bs.modal", "#modal-modif-client", function () {
    var tmpRowModalClientProjet = [];
    var tmpRowModalClientContact = [];
    /*TODO : mettre les formulaire a 0 */
});

$(document).on('click', '#table-modal-client-projets-body tr td:last-child', function () {
    var parent = $(this).parent('tr');
    var idP = parent.attr('value');
    var size = tmpRowModalClientProjet.length;
    tmpRowModalClientProjet[size] = {};
    tmpRowModalClientProjet[size]["idProjet"] = idP;
    parent.remove();
});


$(document).on('click', '#table-modal-client-contacts-body tr td:last-child', function () {
    var parent = $(this).parent('tr');

    if ($(this).parent('tr').attr("value") != " ") {
        //contact existant
        var idC = $(this).parent('tr').attr("value");
        var size = tmpRowModalClientContact.length;
        tmpRowModalClientContact[size] = {};
        tmpRowModalClientContact[size]["idContact"] = idC;
    } else {
        //contact non existant, a enlver au niveau de la liste des contact
        var arrayLength = listeNewContact.length;
        for (var i = 0; i < arrayLength; i++) {
            var email = parent.find('td').eq(2).text();
            if (listeNewContact[i]["email"] === email) {
                listeNewContact.splice(i, 1);
            }
        }
    }
    parent.remove();
});


/* Afficher les Clients archivés */
function clientsArchived() {
    if ($('#checkBoxClientsArchived').is(":checked")) {
        $('.client-archived').show();
    } else {
        $('.client-archived').hide();
    }
}


/* Afficher les projets terminés dans l'onglet projet  */
function projetTDBTermine() {
    if ($('#checkbox-tdb-rp-projets-termines').is(":checked")) {
        $('.projet-finished').show();
    } else {
        $('.projet-finished').hide();
    }
}


/* Afficher les projets et taches terminés dans l'onglet tache  */
function projetTacheTDBTermine() {
    console.log("JE SUIS APPELLE");



    // transforme en et
    var result = "";

    if ($('#checkbox-tdb-taches-critiques').is(":checked")) {
        result += '.tache-critique';
        //$('.table-center').hide();
        //$('.tache-critique').show();
    }


    if ($('#checkbox-tdb-taches-indisponibles').is(":checked")) {
        result += '.tache-indisponible';
        //$('.table-center').hide();
        //$('.tache-indisponible').show();
    }


    if ($('#checkbox-tdb-taches-semaine-pro').is(":checked")) {
        result += '.tache-commence-semaine-prochaine';
        //$('.table-center').hide();
        //$('.tache-commence-semaine-prochaine').show();
    }

    if ($('#checkbox-tdb-taches-semaine-pro').is(":checked")) {
        result += '.tache-commence-semaine-prochaine';
        //$('.table-center').hide();
        //$('.tache-commence-semaine-prochaine').show();
    }

    if ($('#checkbox-tdb-taches-moins-10j').is(":checked")) {
        result += '.tache-terminee-dans-moins-10-j';
        //$('.table-center').hide();
        //$('.tache-terminee-dans-moins-10-j').show();
    }


    if ($('#checkbox-tdb-taches-retardees').is(":checked")) {
        result += '.tache-retardee';
        //$('.table-center').hide();
        //$('.tache-retardee').show();
    }

    if (result.length > 0) {
        $('.table-center').hide();
        console.log("result = " + result);
        $(result).show();
    }
    else {
        $('.table-center').show();  // TODO MODIFIER EN FONCTION DES CHECKBOX

    }
    if ($('#checkbox-tdb-collab-projets-termines').is(":checked")) {
        $('.projet-finished').show();
    }
    else {
        $('.projet-finished').hide();
    }

    console.log("Je suis la?");
    if ($('#checkbox-tdb-collab-taches-termines').is(":checked")) {
        console.log("termine --- ")
        $('.tache-terminee').show();
    }
    else {
        console.log("hide termine --- ")

        $('.tache-terminee').hide();
    }

}


function filtreTDBproj() {
    var result = "";
    if ($('#checkbox-tdb-rp-projets-termines').is(":checked")) {
        //$('.projet-finished').show();
        result += '.projet-finished';
    }
    else {
       // $('.projet-finished').hide();
    }


    if ($('#checkbox-tdb-projets-retardes').is(":checked")) {
        result += '.projet-retarde';

    }
    if ($('#checkbox-tdb-projets-bientot-finis').is(":checked")) {
        result += '.projet-presque-fini';

    }

    if (result.length > 0) {
        $('.table-center').hide();
        console.log("result = " + result);
        $(result).show();
    }
    else {
        $('.table-center').show();  // TODO MODIFIER EN FONCTION DES CHECKBOX
    }


}


/* Afficher les utilisateurs archivés */
function utilisateursArchived() {
    if ($('#checkboxUsersArchived').is(":checked")) {
        $('.user-archived').show();
    } else {
        $('.user-archived').hide();
    }
}

function reverse(string) {
    if (string === null) {
        return "";
    } else {
        var res = string.split('/');
        var final = res[2] + '/' + res[1] + '/' + res[0];
        return final;
    }

}

function verif(string) {
    if (string === null) {
        return "";
    } else {
        return string;
    }
}


//TODO : changer pour la partie consommee
var checkBoxProjetTermine = '#checkbox-projet-admin-projets-termines';
var checkBoxProjetArchive = '#checkbox-projet-admin-projets-archives';
function projetTermines() {
    if ($(checkBoxProjetTermine).is(":checked") && $(checkBoxProjetArchive).is(":checked")) {
        $('.projet-archived-finished').show();
        $('.projet-archived').show();
        $('.projet-finished').show();
    }
    else if ($(checkBoxProjetTermine).is(":checked")) {
        $('.projet-archived-finished').hide();
        $('.projet-finished').show();
    }
    else {
        $('.projet-archived-finished').hide();
        $('.projet-finished').hide();
    }
}


function projetArchives() {
    if ($(checkBoxProjetArchive).is(":checked") && $(checkBoxProjetTermine).is(":checked")) {
        $('.projet-archived-finished').show();
        $('.projet-archived').show();
        $('.projet-finished').show();
    }
    else if ($(checkBoxProjetArchive).is(":checked")) {
        $('.projet-archived-finished').hide();
        $('.projet-archived').show();
    }
    else {
        $('.projet-archived-finished').hide();
        $('.projet-archived').hide();
    }
}

$(document).on("click", "#exporter-client", function (event) {
    window.open(window.location + "getClientsAsCSV");
});


//####################################################################
//                         DRAFT PARSING
//####################################################################


function parseDraft(idProjet) {
    function ajoutTacheFille(tacheMere, tache) {
        tacheMere["childrens"].push(tache);
    }

    function creerTache(tacheId, index, depth) {
        var tache = {};
        tache["index"] = index;
        tache["depth"] = depth;
        tache["id"] = tacheId;
        tache["childrens"] = new Array();
        return tache;
    }

    var taches = {};
    taches["projectId"] = idProjet;
    taches["taches"] = new Array();

    var processNodes = function (currentElement, depth, taches, parent, index) {
        var currentTache;
        if ($(currentElement).is("li")) {
            currentTache = creerTache($(currentElement).attr('data-id'), index, depth);
            console.log("depth: " + depth);
            if (depth == 0) {
                taches["taches"].push(currentTache);
            }
            else {
                ajoutTacheFille(parent, currentTache);
            }

            console.log(Array(depth + 1).join("--") + " " + $(currentElement).attr('data-id'));
        }

        var indexChild = 0;
        if ($(currentElement).children().size() == 2 && $(currentElement).children().eq(1).is("ol")) {

            $(currentElement).children().eq(1).children().each(function unFunction(element) {
                depth = depth + 1;
                processNodes($(this), depth, taches, currentTache, indexChild++);
            });
            depth = depth - indexChild - 1;
        }
    }


    var depth = 0;
    var indexChild = 0;
    $("#table_taches_" + idProjet).children().each (function processNodesTmp() {
        processNodes(this, depth, taches, null, indexChild++);

    });
    var json = JSON.stringify(taches);
    console.log(json);
    return json;
}

//####################################################################

//######### Modifier projet ##########


var supprimerClient = function () {
    var $value = $tmpTrAdminClient.attr('value');
    console.log($value);
    jsRoutes.controllers.AdminController.supprimerClient($value).ajax({
        success: function (html) {
            $tmpTrAdminClient.addClass("client-archived");
            $tmpTrAdminClient.children('td').eq(6).html(messages("yes"));
            $tmpTrAdminClient.children('td').eq(7).removeClass('td-modal');
            $tmpTrAdminClient.children('td').eq(7).addClass('td-btn-suppr-disable');
            $tmpTrAdminClient.children('td').eq(7).attr("data-target", "");
            $tmpTrAdminClient.children('td').attr("data-target", "#modal-modif-client-disable");
            if (!$('#checkBoxClientsArchived').is(":checked")) {
                $tmpTrAdminClient.hide();
            }
        },
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });
}

var clickNotificationsLues = function (idUser) {
    var listIdNotif = "";
    $("div.checkbox-notif input:checked").each(function () {
        listIdNotif += $(this).attr("name") + ",";
    });
    if (listIdNotif.length > 0) {
        listIdNotif = listIdNotif.substring(0, listIdNotif.length - 1);
        console.log(listIdNotif);
        jsRoutes.controllers.NotificationController.clickNotificationsLues(idUser, listIdNotif).ajax({
            success: function (nbNotifNonLues) {
                var listIdNotifSplit = listIdNotif.split(",");
                for (var i = 0; i < listIdNotifSplit.length; i++) {
                    var idNotif = listIdNotifSplit[i];
                    $('#notif-' + idNotif).removeClass('non-lu');
                    $('#notif-' + idNotif).addClass('lu');
                    if ($('#notif-' + idNotif).next().is('tr.footable-row-detail')) {
                        //$('#notif-etatLecture-' + idNotif).html(messages("read"));
                        $('#notif-' + idNotif).next().children().first().children().first().children().first().children().eq(1).html(messages("read"));
                    }
                    else {
                        $('#notif-etatLecture-' + idNotif).html(messages("read"));
                    }
                    $('#nbNotifNonLues-pageNotif').html(nbNotifNonLues);
                    $('#nbNotifNonLues-topbar').html(nbNotifNonLues);
                    console.log("Nb de notifs non lues = " + nbNotifNonLues);
                }
            },
            error: function () {
            }
        });
    }
}

var supprimerUtilisateur = function () {
    $("#error-message-suppr-user-projet").hide();
    $("#error-message-suppr-user-tache").hide();

    var idUtilisateur = $tmpTrAdminUser.attr('value');
    console.log('Utilisateur a supprimer : ' + idUtilisateur);
    //<idProjet,idUtilisateur>
    var mapProjet = "";
    //<idTache; idUtilisateur>
    var mapTache = "";

    /* tester si ils sont tous remplis  exit = return; */
    var error = false;
    $("#table-modal-suppr-user-projet-body > tr").each(function () {
        var projectID = $(this).attr('value');
        try {
            var idUserSelected = $(this).children('td').eq(1).children('select').select2().val()[0];
        } catch (e) {
            $("#error-message-suppr-user-projet").show();
            error = true;
        }
        mapProjet += projectID + "," + idUserSelected + ";";
    });

    $("#table-modal-suppr-user-tache-body > tr").each(function () {
        var tacheID = $(this).attr('value');
        try {
            var idUserSelected = $(this).children('td').eq(2).children('select').select2().val()[0];
        } catch (e) {
            $("#error-message-suppr-user-tache").show();
            error = true;
        }
        mapTache += tacheID + "," + idUserSelected + ";";

    });

    if (error) {
        return;
    }

    console.log(mapProjet);
    console.log(mapTache);

    jsRoutes.controllers.UtilisateurController.supprimerUtilisateur(idUtilisateur, mapProjet, mapTache).ajax({
        success: function () {
            $('#modal-suppr-user').modal('hide');
            $tmpTrAdminUser.addClass("user-archived");

            $tmpTrAdminUser.children('td').eq(6).html(messages("yes"));
            $tmpTrAdminUser.children('td').eq(7).removeClass('td-modal');
            $tmpTrAdminUser.children('td').eq(7).addClass('td-btn-suppr-disable');
            $tmpTrAdminUser.children('td').attr("data-target", "#modal-modif-user-disable");
            if (!$('#checkboxUsersArchived').is(':checked')) {
                $tmpTrAdminUser.hide();
            }

            jsRoutes.controllers.UtilisateurController.allUsers().ajax({
                success: function (users) {
                    //console.log(users);
                    var userContent = "";
                    $("#dataTables-admin-user").dataTable().fnDestroy();

                    var userTableBody = $('#dataTables-admin-user-body');
                    userTableBody.empty();
                    $.each(users, function (i, utilisateur) {
                        console.log(utilisateur);
                        var archive;
                        if (utilisateur.archive) {
                            userContent += ('<tr class="user-archived" value="' + utilisateur.id + '">');
                            archive = "-disabled";
                        } else {
                            userContent += ('<tr value="' + utilisateur.id + '">');
                            archive = "";
                        }

                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.nom + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.prenom + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.email + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.telephone + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.listProjetsResponsableSize + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">' + utilisateur.listTachesSize + '</td>');
                        userContent += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user' + archive + '">');
                        if (archive == "-disabled") {
                            userContent += (messages("yes") + '</td>');
                            userContent += ('<td class="td-btn-suppr-disable" style="vertical-align:middle ;"><i class="fa fa-times"></i></td></tr>');
                        } else {
                            userContent += (messages("no") + '</td>');
                            userContent += ('<td class="td-btn-suppr" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-suppr-user"><i class="fa fa-times"></i></td></tr>');
                        }
                    });

                    console.log(userContent);
                    //table.clear();
                    userTableBody.append(userContent);
                }
            });
        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });

}


$(document).on('click','#btnAdminOuiCreer', function() {
    $(this).addClass("btn-active");
    $('#btnAdminNonCreer').removeClass("btn-active");

});

$(document).on('click','#btnAdminNonCreer', function() {
    $(this).addClass("btn-active");
    $('#btnAdminOuiCreer').removeClass("btn-active");
});


var creerUtilisateur = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serialize();
    var value = "Non";
    if ($("#btnAdminOuiCreer").hasClass("btn-active")) {
        value = "Oui";
    }
    console.log("value : " + value);
    jsRoutes.controllers.UtilisateurController.creerUtilisateur().ajax({
        data: serialize + "&admin=" + value,
        success: function (data) {
            $("#errorCreerUserP").empty();
            $("#errorCreerUser").hide();

            $(form)[0].reset();
            console.log("data return = " + data.nom);

            var utilisateurList = $('#dataTables-admin-user-body');
            $("#dataTables-admin-user").dataTable().fnDestroy();

            var utilisateur = data;
            var list = generateRowUtilisateur(utilisateur);
            utilisateurList.append(list);

            $("#successCreerUserP").html(messages("user") + ' ' + utilisateur.nom + ' ' + utilisateur.prenom + ' ' + messages("created"));
            $("#successCreerUser").show();
            setTimeout(function () {
                $("#successCreerUser").hide();
            }, 4000);
        },
        error: function (errorMessage) {
            console.log(errorMessage);
            $("#successCreerUser").hide();
            $("#successCreerUserP").empty();

            var messageDiv = generateErrorUtilisateur(errorMessage);

            $("#errorCreerUserP").html(messageDiv);
            $("#errorCreerUser").show();

        }
    })
}

function generateErrorUtilisateur(errorMessage) {
    var messageDiv = messages("errors") + ' : ';
    if (errorMessage.responseJSON.nomVide == true) {
        messageDiv += '<br> - ' + messages("lastnameEmptyError");
    }
    else if (errorMessage.responseJSON.nomTropLong == true) {
        messageDiv += '<br> - ' + messages("lastnameTooLongError");
    }
    else if (errorMessage.responseJSON.nomIncorrect == true) {
        messageDiv += '<br> - ' + messages("lastnameIncorrectError");
    }

    if (errorMessage.responseJSON.prenomVide == true) {
        messageDiv += '<br> - ' + messages("firstnameEmptyError");
    }
    else if (errorMessage.responseJSON.prenomTropLong == true) {
        messageDiv += '<br> - ' + messages("firstnameTooLongError");
    }
    else if (errorMessage.responseJSON.prenomIncorrect == true) {
        messageDiv += '<br> - ' + messages("firstnameIncorrectError");
    }


    if (errorMessage.responseJSON.emailVide == true) {
        messageDiv += '<br> - ' + messages("emailEmptyError");
    }
    else if (errorMessage.responseJSON.emailIncorrecte == true) {
        messageDiv += '<br> - ' + messages("emailIncorrectError");
    }
    else if (errorMessage.responseJSON.emailTropLong == true) {
        messageDiv += '<br> - ' + messages("emailTooLongError");
    }

    if (errorMessage.responseJSON.telVide == true) {
        messageDiv += '<br> - ' + messages("telEmptyError");
    }
    else if (errorMessage.responseJSON.telIncorrecte == true) {
        messageDiv += '<br> - ' + messages("telIncorrectError");
    }
    else if (errorMessage.responseJSON.telTropLong == true) {
        messageDiv += '<br> - ' + messages("telTooLongError");
    }

    if (errorMessage.responseJSON.userExist) {
        messageDiv += '<br> - /!\\ ' + messages("emailAlreadyUsed");
    }
    return messageDiv;
}

function generateRowUtilisateur(utilisateur) {
    var list = "";
    list += ('<tr class="archived" value=' + utilisateur.id + '>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.nom + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.prenom + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.email + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.telephone + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.listProjetsResponsableSize + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + utilisateur.listTachesSize + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">' + messages("no") + '</td>');
    list += ('<td class="td-btn-suppr" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-suppr-user"><i class="fa fa-times"></i></td>');
    list += ('</tr>');

    return list;
}

var modifierUtilisateur = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serialize();
    var value = "Non";
    if ($("#btnAdminOuiModifier").hasClass("btn-active")) {
        value = "Oui";
    }
    var idUtilisateur = userRow.attr('value');

    console.log("value : " + value);
    jsRoutes.controllers.UtilisateurController.modifierUtilisateur(idUtilisateur).ajax({
        data: serialize + "&admin=" + value,
        success: function (data) {
            $("#errorModifierUserP").empty();
            $("#errorModifierUser").hide();


            console.log("data return = " + data.nom);

            var utilisateurList = $('#dataTables-admin-user-body');
            $("#dataTables-admin-user").dataTable().fnDestroy();
            userRow.remove();

            var utilisateur = data;

            var list = generateRowUtilisateur(utilisateur);

            utilisateurList.append(list);

            $("#successModifierUserP").html(messages("user") + ' ' + utilisateur.nom + ' ' + utilisateur.prenom + ' ' + messages("modified"));
            $("#successModifierUser").show();
            setTimeout(function () {
                $("#successModifierUser").hide();
            }, 4000);
        },
        error: function (errorMessage) {
            console.log(errorMessage);
            $("#successModifierUser").hide();
            $("#successModifierUserP").empty();

            var messageDiv = generateErrorUtilisateur(errorMessage);

            $("#errorModifierUserP").html(messageDiv);
            $("#errorModifierUser").show();
        }
    });
}

var modifierClient = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serializeObject();
    var value = $("#btnModifierClient .btn-active").attr('value');
    var idClient = clientRow.attr('value');
    var json = "{\"form\":" + JSON.stringify(serialize) + ",\"table\":" + JSON.stringify(listeNewContact) + ",\"projet\":" + JSON.stringify(tmpRowModalClientProjet) + ",\"contact\":" + JSON.stringify(tmpRowModalClientContact) + ",\"priorite\":" + value + "}";
    console.log(json);
    jsRoutes.controllers.ClientController.modifierClient(idClient).ajax({
        data: json,
        contentType: "application/json",
        success: function (data) {
            $("#errorModifierClientP").empty();
            $("#errorModifierClient").hide();

            $("#successModifierClientP").html(messages("client") + ' ' + data.nom + ' ' + messages("modified"));
            $("#successModifierClient").show();
            setTimeout(function () {
                $("#successModifierClient").hide();
            }, 4000);

            // Affichage des vrai valeur maitenant


            var clientList = $('#dataTables-admin-client-body');
            //mise a jour modal en fonction du truc de guillaume
            listeNewContact = [];
            tmpRowModalClientProjet = [];
            tmpRowModalClientContact = [];
            modal(data, data.id);
            $("#dataTables-admin-client").dataTable().fnDestroy();
            clientRow.remove();
            var list = generateRowClient(data);
            clientList.append(list);

        },
        error: function (errorMessage) {
            $("#successModifierClient").hide();
            $("#successModifierClientP").empty();

            var messageDiv = generateErrorCreerClient(errorMessage);

            $("#errorModifierClientP").html(messageDiv);
            $("#errorModifierClient").show();
        }
    });
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

var creerClient = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serializeObject();
    //var myRows = { myRows: [] };
    var value = $("#btnCreerClient .btn-active").attr('value');
    var $th = $('#tableContact th');

    var rowCount = $('#tableContact tbody tr').length;
    if (rowCount != 0) {
        var tbl = $('#tableContact tr:has(td)').map(function (i, v) {
            var $td = $('td', this);
            return {
                Nom: $td.eq(0).text(),
                Prenom: $td.eq(1).text(),
                Email: $td.eq(2).text(),
                Tel: $td.eq(3).text()
            }
        }).get();
        var json = "{\"form\":" + JSON.stringify(serialize) + ",\"table\":" + JSON.stringify(tbl) + ",\"priorite\":" + value + "}";
    } else {
        var json = "{\"form\":" + JSON.stringify(serialize) + ",\"priorite\":" + value + "}";
    }

    jsRoutes.controllers.ClientController.creerClient().ajax({
        data: json,
        contentType: "application/json",

        success: function (data) {

            $("#errorCreerClientP").empty();
            $("#errorCreerClient").hide();

            $("#successCreerClientP").html(messages("client") + ' ' + data.nom + ' ' + messages("created"));
            $("#successCreerClient").show();
            setTimeout(function () {
                $("#successCreerClient").hide();
            }, 4000);

            $(form)[0].reset();
            $('#tableContact tr:not(:first)').remove();
            $('#listContactAjout').hide();

            var clientList = $('#dataTables-admin-client-body');
            $("#dataTables-admin-client").dataTable().fnDestroy();

            var utilisateur = data;
            var list = generateRowClient(data);
            clientList.append(list);

        },
        error: function (errorMessage) {
         //   alert("ERROR ");
            $("#successCreerClient").hide();
            $("#successCreerClientP").empty();
            console.log(JSON.stringify(errorMessage));
            var messageDiv = generateErrorCreerClient(errorMessage);

            $("#errorCreerClientP").html(messageDiv);
            $("#errorCreerClient").show();
        }
    });
}

function generateRowClient(client) {
    var list;
    list += ('<tr value=' + client.id + '>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' + client.nom + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' +
    client.adresseClient.adresse + ", " + client.adresseClient.zipCode + ", " + client.adresseClient.ville + ", " + client.adresseClient.pays +
    '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' + client.listContactsSize + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' + client.listProjetsSize + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' + client.listTachesSize + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">' + client.priorite + '</td>');
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">'+messages("no")+'</td>');
    list += ('<td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal"><i class="fa fa-times"></i></td>');
    list += ('</tr>');

    return list;
}

function generateErrorCreerClient(errorMessage) {
    var messageDiv = messages("errors") + ' : ';

    if (errorMessage.responseJSON.nomClientVide == true) {
        messageDiv += '<br> - ' + messages("nameClientEmptyError");
    }
    else if (errorMessage.responseJSON.nomClientTropLong == true) {
        messageDiv += '<br> - ' + messages("nameClientTooLongError");
    }
    else if (errorMessage.responseJSON.nomIncorrect == true) {
        messageDiv += '<br> - ' + messages("nameIncorrectError");
    }

    if (errorMessage.responseJSON.adresseVide == true) {
        messageDiv += '<br> - ' + messages("adressEmptyError");
    }
    else if (errorMessage.responseJSON.adresseTropLong == true) {
        messageDiv += '<br> - ' + messages("adressTooLongError");
    }
    if (errorMessage.responseJSON.codePostalVide == true) {
        messageDiv += '<br> - ' + messages("zipEmptyError");
    }
    else if (errorMessage.responseJSON.codePostalTropLong == true) {
        messageDiv += '<br> - ' + messages("zipTooLongError");
    }
    if (errorMessage.responseJSON.villeVide == true) {
        messageDiv += '<br> - ' + messages("cityEmptyError");
    }
    else if (errorMessage.responseJSON.villeTropLong == true) {
        messageDiv += '<br> - ' + messages("cityTooLongError");
    }
    if (errorMessage.responseJSON.paysVide == true) {
        messageDiv += '<br> - ' + messages("stateEmptyError");
    }
    else if (errorMessage.responseJSON.paysTropLong == true) {
        messageDiv += '<br> - ' + messages("stateTooLongError");
    }

    if (errorMessage.responseJSON.clientExiste) {
        messageDiv += '<br> - /!\\ ' + messages("clientExistError");
    }
    return messageDiv;
}

var creerContact = function (btn) {
    console.log("ICI");
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serialize();
    console.log(serialize);
    jsRoutes.controllers.ClientController.contactCheck().ajax({
        data: serialize,
        success: function (data) {
            var $email = data.email;
            var $length = $('#listContactAjout tr > td:contains(' + $email + ')').length;
            if ($length > 0) {
                $("#successCreerClient").hide();
                $("#successCreerClientP").empty();
                var messageDiv = '<br> - /!\\ ' + messages("emailAlreadyUsed");
                $("#errorCreerClientP").html(messageDiv);
                $("#errorCreerClient").show();
            } else {
                $("#errorCreerClientP").empty();
                $("#errorCreerClient").hide();

                $("#successCreerClientP").html(messages("contact") + data.nom + ' ' + data.prenom + messages("created"));
                $("#successCreerClient").show();

                if ($('#listContactAjout').not(':visible')) {
                    $('#listContactAjout').show();
                }
                setTimeout(function () {
                    $("#successCreerClient").hide();
                }, 4000);
                var contact = $('#tableContact tbody');
                var list = "";

                list += ('<tr>');
                list += ('<td class="first-td">' + data.nom + '</td>');
                list += ('<td class="first-td">' + data.prenom + '</td>');
                list += ('<td class="first-td">' + data.email + '</td>');
                list += ('<td class="first-td">' + data.telephone + '</td>');
                list += ('<td class="td-btn-suppr" style="vertical-align:middle;" onclick="supprContact(this)"><i class="fa fa-times"></i></td>');
                list += ('</tr>');
                contact.append(list);
                $(form)[0].reset();

            }
        },
        error: function (errorMessage) {
            $("#successCreerClient").hide();
            $("#successCreerClientP").empty();
            var messageDiv = generateErrorCreerClientContact(errorMessage);
            $("#errorCreerClientP").html(messageDiv);
            $("#errorCreerClient").show();
        }
    });
}

function generateErrorCreerClientContact(errorMessage) {
    var messageDiv = messages("errors") + ' : ';

    if (errorMessage.responseJSON.nomVideContact == true) {
        messageDiv += '<br> - ' + messages("lastnameEmptyError");
    }
    else if (errorMessage.responseJSON.nomIncorrectContact == true) {
        messageDiv += '<br> - ' + messages("lastnameIncorrectError");
    }else if (errorMessage.responseJSON.nomTropLongContact == true) {
        messageDiv += '<br> - ' + messages("lastnameTooLongError");
    }

    if (errorMessage.responseJSON.prenomVideContact == true) {
        messageDiv += '<br> - ' + messages("firstnameEmptyError");
    }
    else if (errorMessage.responseJSON.prenomIncorrectContact == true) {
        messageDiv += '<br> - ' + messages("firstnameIncorrectError");
    }
    else if (errorMessage.responseJSON.prenomTropLongContact == true) {
        messageDiv += '<br> - ' + messages("firstnameTooLongError");
    }



    if (errorMessage.responseJSON.emailVideContact == true) {
        messageDiv += '<br> - ' + messages("emailEmptyError");
    }
    else if (errorMessage.responseJSON.emailIncorrecteContact == true) {
        messageDiv += '<br> - ' + messages("emailIncorrectError");
    }
    else if (errorMessage.responseJSON.emailTropLongContact == true) {
        messageDiv += '<br> - ' + messages("emailTooLongError");
    }

    if (errorMessage.responseJSON.telVideContact == true) {
        messageDiv += '<br> - ' + messages("telEmptyError");
    }
    else if (errorMessage.responseJSON.telIncorrecteContact == true) {
        messageDiv += '<br> - ' + messages("telIncorrectError");
    }
    else if (errorMessage.responseJSON.telTropLongContact == true) {
        messageDiv += '<br> - ' + messages("telTooLongError");
    }
    if (errorMessage.responseJSON.contactExiste == true) {
        messageDiv += '<br> - ' + messages("contactExist");
    }

    return messageDiv;
}

var afficherModalTache = function (t) {

    var idTache = $(t).attr('value');

    console.log('tache hihihi ' + idTache);

    jsRoutes.controllers.DashboardController.afficherModalTache(idTache).ajax({
        type: 'POST',
        dataType: 'json',
        contentType: "application/json",
        success: function (tache) {
            //console.log(JSON.stringify(tache));
            $("#dataTables-tdb-tache").dataTable().fnDestroy();
            $("#errorModifierTache").hide();
            // div-consulter-tache
            if (tache.critique) {
                $('#imgCritique-consulterTache-tdb').show();
            }
            else {
                $('#imgCritique-consulterTache-tdb').hide();
            }

            $('#formModifierTache').attr('value', tache.id);

            $('#idTache-consulter-tdb').html(tache.idTache);
            $('#idTache-modifier-tdb').html(tache.idTache);
            $('#nomTache-consulter-tdb').html(tache.nom);
            $('#formModifierNomTache-tdb').val(tache.nom);
            $('#descriptionTache-consulter-tdb').html(tache.description);
            $('#formModifierDescriptionTache-tdb').val(tache.description);
            $('#btn-indisponibleTache').attr("data", tache.id);
            $('#btn-indisponibleTache-modifier').attr("data", tache.id);
            if (!tache.disponible) {
                $('#btn-indisponibleTache i').removeClass("fa-unlock");
                $('#btn-indisponibleTache i').removeClass("fa-lock");

                $('#btn-indisponibleTache i').addClass("fa-lock");

                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");

                $('#btn-indisponibleTache-modifier i').addClass("fa-lock");

            }
            else {
                $('#btn-indisponibleTache i').removeClass("fa-lock");
                $('#btn-indisponibleTache i').removeClass("fa-unlock");

                $('#btn-indisponibleTache i').addClass("fa-unlock");


                $('#btn-indisponibleTache-modifier i').removeClass("fa-lock");
                $('#btn-indisponibleTache-modifier i').removeClass("fa-unlock");

                $('#btn-indisponibleTache-modifier i').addClass("fa-unlock");
            }

            jsRoutes.controllers.UtilisateurController.afficherUtilisateursNonArchives().ajax({
                success: function (utilisateurs) {
                    var list = "";
                    $(utilisateurs).each(function (index, u) {
                        if (u.email == tache.responsableTache.email) {
                            list += '<option value="' + u.id + '" selected>' + u.nom + ' ' + u.prenom + '</option>';
                        }
                        else {
                            list += '<option value="' + u.id + '">' + u.nom + ' ' + u.prenom + '</option>';
                        }
                    });

                    $('#responsableTacheModifier').html(list);
                },
                error: function (errorMessage) {
                    alert(errorMessage);
                }
            });

            jsRoutes.controllers.DashboardController.getAllPredecesseursPossible(tache.id).ajax({
                success: function (taches) {
                    //console.log(taches);
                    var list = "";

                    $(taches).each(function (index, t) {
                        if (t.id == tache.predecesseurId) {
                            list += '<option value="' + t.id + '" selected>' + t.idTache + ' - ' + t.nom + '</option>';
                        }
                        else {
                            list += '<option value="' + t.id + '">' + t.idTache + ' - ' + t.nom + '</option>';
                        }
                    });

                    $('#form-tache-predecesseur').html(list);
                },
                error: function (errorMessage) {
                    alert(errorMessage);
                }
            });

            jsRoutes.controllers.DashboardController.getAllSucesseursPossible(tache.id).ajax({
                success: function (taches) {
                    //console.log(taches);
                    var list = "";

                    $(taches).each(function (index, t) {
                        var isSuccesseur = false;
                        $(tache.successeurs).each(function (index, s) {
                            if (t.id == s.id) {
                                isSuccesseur = true;
                                return;
                            }
                        });
                        if (isSuccesseur) {
                            list += '<option value="' + t.id + '" selected>' + t.idTache + ' - ' + t.nom + '</option>';
                        } else {
                            list += '<option value="' + t.id + '">' + t.idTache + ' - ' + t.nom + '</option>';
                        }
                    });

                    $('#form-tache-successeur').html(list);
                },
                error: function (errorMessage) {
                    alert(errorMessage);
                }
            });

            if (!tache.predecesseurNom) {
                $('#titre-predecesseur-consulter-tdb').hide()
                $('#table-predecesseurTache-consulter-tdb').hide();
            }
            else {
                $('#titre-predecesseur-consulter-tdb').show()
                $('#table-predecesseurTache-consulter-tdb').show();
                $('#table-predecesseurTache-consulter-tdb table tbody tr .id-task').html(tache.predecesseurIdTache);
                $('#table-predecesseurTache-consulter-tdb table tbody tr .name-task').html(tache.predecesseurNom);

                console.log('#predecesseurTache-' + tache.predecesseurId);

            }
            /*console.log("tache = "+JSON.stringify(tache))
             console.log("predecesseurNom : "+tache.predecesseurNom);
             console.log("predecesseurId : "+tache.predecesseurId);
             console.log("Successeurs : "+tache.successeurs);*/

            var list = "";
            var listModifier = "";
            if (tache.successeurs.length > 0) {
                $('#titre-successeurs-consulter-tdb').show()
                $('#table-successeursTache-consulter-tdb').show();
                $(tache.successeurs).each(function (index, tache) {
                    list += '<tr>';
                    list += '<td class="id-task">' + tache.idTache + '</td>';
                    list += '<td class="name-task">' + tache.nom + '</td>';
                    list += '</tr>';
                });
                $('#table-successeursTache-consulter-tdb-body').html(list);
            } else {
                $('#titre-successeurs-consulter-tdb').hide()
                $('#table-successeursTache-consulter-tdb').hide();
            }

            list = "";
            listModifier = "";
            if (tache.interlocuteurs) {
                $(tache.interlocuteurs).each(function (index, contact) {
                    list += '<li id="' + contact.id + '">' + contact.nom + ' ' + contact.prenom + '</li>';
                });

                jsRoutes.controllers.DashboardController.getAllInterlocuteur(tache.projet.id).ajax({
                    success: function (interlocuteursClient) {
                        //console.log(JSON.stringify(interlocuteursClient));
                        //console.log(JSON.stringify(tache.interlocuteurs));
                        //console.log("diff = "+JSON.stringify(compareJSON(interlocuteursClient,tache.interlocuteurs)));
                        var i = 0;
                        for (var key in tache.interlocuteurs) {
                            listModifier += '<li><div class="checkbox checkbox-success checkbox-dropdown">';
                            listModifier += '<input id="checkbox-interlocuteur-' + i + '" type="checkbox"  value="' + tache.interlocuteurs.id + '" checked>';
                            listModifier += '<label for="checkbox-interlocuteur-' + i + '">';
                            listModifier += tache.interlocuteurs[key].nom + ' ' + tache.interlocuteurs[key].prenom + '</label></div></li>';
                            i++;
                        }
                        var interlocuteurNonCoche = compareJSON(interlocuteursClient, tache.interlocuteurs);
                        for (var key in interlocuteurNonCoche) {
                            listModifier += '<li><div class="checkbox checkbox-success checkbox-dropdown">';
                            listModifier += '<input id="checkbox-interlocuteur-' + i + '" type="checkbox" value="' + interlocuteurNonCoche[key].id + '">';
                            listModifier += '<label for="checkbox-interlocuteur-' + i + '">';
                            listModifier += interlocuteurNonCoche[key].nom + ' ' + interlocuteurNonCoche[key].prenom + '</label></div></li>';
                            i++;
                            console.log("key " + key)
                        }
                        $('#nbInterlocuteurModifier').html(interlocuteursClient.length);
                        $('#interlocuteurs-modifier').html(listModifier);

                    },
                    error: function (errorMessage) {
                        alert(errorMessage);
                    }
                });


                $('#nbInterlocuteur').html(tache.interlocuteurs.length);

            }

            $('#interlocuteurs-consulter').html(list);
            console.log("============> " + JSON.stringify(tache.interlocuteurs));

            var mailToSTRING = "mailto:";
            $.each(tache.interlocuteurs, function (index, value) {
                mailToSTRING += (value.email + ";");
            });
            console.log(mailToSTRING);
            //$("#interlocuteurs-consulter").html("<a href=\"" + mailToSTRING + "\"></a>");
            $("#mail-to-interlocuteur").attr('href', mailToSTRING);

            $('#nomProjet-consulter-tdb').html(tache.projet.nom);
            $('#nomClient-consulter-tdb').html(tache.projet.client.nom);
            $('#nomProjet-modifier-tdb').html(tache.projet.nom);
            $('#nomClient-modifier-tdb').html(tache.projet.client.nom);
            $('#nomRespTache-consulter-tdb').html(tache.responsableTache.nom + " " + tache.responsableTache.prenom);
            $('#avancementTache').html((Math.round(tache.avancementTache * 100)) + "%");
            $('#avancementTache').attr("aria-valuenow", (Math.round(tache.avancementTache * 100)));
            $('#avancementTache').css("width", (Math.round(tache.avancementTache * 100)) + "%");
            if (parseInt((Math.round(tache.avancementTache * 100))) < 7) {
                $('#avancementTache').css("color", "#000");
            }
            else {
                $('#avancementTache').css("color", "#FFF");
            }
            $('#nbJourRestant').html(messages("remainingTime") + " : " + tache.nbJourRestant + " " + messages("day-first-letter"));
            $('#dateDebutTache').html(tache.dateDebut);
            $('#dateFinTotTache').html(tache.dateFinTot);
            $('#dateFinTardTache').html(tache.dateFinTard);
            $('#DD-modifier').attr("value", tache.dateDebut);
            $('#DFTO-modifier').attr("value", tache.dateFinTot);
            $('#DFTA-modifier').attr("value", tache.dateFinTard);
            var unite = tache.projet.unite;
            if (unite == "JOUR") {
                unite = messages("day-first-letter");
            }
            else {
                unite = messages("week-first-letter");
            }
            //console.log(JSON.stringify(tache));
            $('#chargeInitialeTache').html(messages("initial") + ' : ' + tache.chargeInitiale + unite);
            $('#chargeRestanteTache').html(messages("remaining") + ' : ' + tache.chargeRestante + unite);
            $('#chargeConsommeeTache').html(messages("consumed") + ': ' + tache.chargeConsommee + unite);
            $('#formModifierChargeInitiale').val(tache.chargeInitiale);
            $('#formModifierChargeInitiale').nextAll('span').html(unite);
            $('#formModifierChargeRestante').val(tache.chargeRestante);
            $('#formModifierChargeRestante').nextAll('span').html(unite);
            $('#formModifierChargeConsommee').val(tache.chargeConsommee);
            $('#formModifierChargeConsommee').nextAll('span').html(unite);

            if (tache.disponible) {
                $('.formModifierChargeRestante').attr("disabled", false);
                $('.formModifierChargeConsommee').attr("disabled", false);
            } else {
                $('.formModifierChargeRestante').attr("disabled", true);
                $('.formModifierChargeConsommee').attr("disabled", true);
            }

            //Activation/désactivation des inputs
            jsRoutes.controllers.Login.utilisateurConnecte().ajax({
                success: function (utilisateur) {

                    jsRoutes.controllers.UtilisateurController.isAdmin().ajax({
                        success: function (isAdmin) {
                            if(isAdmin == "false") {
                                if (utilisateur.id != tache.projet.responsableProjet.id) {
                                    changeDisablePropretyFormulaireModifierTache(true);
                                    $('#modalConsulterSupprimerTache').hide();
                                    $('#modalModifierSupprimerTache').hide();
                                    $('#btn-indisponibleTache').hide();
                                    $('#btn-indisponibleTache-modifier').hide();
                                } else {
                                    changeDisablePropretyFormulaireModifierTache(false);
                                    $('#modalConsulterSupprimerTache').show();
                                    $('#modalModifierSupprimerTache').show();
                                    $('#btn-indisponibleTache').show();
                                    $('#btn-indisponibleTache-modifier').show();
                                }
                            } else {
                                if($(".active").hasClass('sidebar-btn-green')){
                                    if (utilisateur.id != tache.projet.responsableProjet.id) {
                                        changeDisablePropretyFormulaireModifierTache(true);
                                        $('#btn-indisponibleTache').hide();
                                        $('#btn-indisponibleTache-modifier').hide();
                                        $('#modalConsulterSupprimerTache').hide();
                                        $('#modalModifierSupprimerTache').hide();
                                    } else {
                                        changeDisablePropretyFormulaireModifierTache(false);
                                        $('#btn-indisponibleTache').show();
                                        $('#btn-indisponibleTache-modifier').show();
                                        $('#modalConsulterSupprimerTache').show();
                                        $('#modalModifierSupprimerTache').show();
                                    }
                                }
                                else {
                                    changeDisablePropretyFormulaireModifierTache(false);
                                    $('#btn-indisponibleTache').show();
                                    $('#btn-indisponibleTache-modifier').show();
                                }
                            }
                        },
                        error: function (errorMessage) {
                        }
                    });

                    if (tache.disponible && !tache.hasEnfant) {
                        changeDisablePropertyChargesFormulaireTache(false);
                    } else {
                        changeDisablePropertyChargesFormulaireTache(true);
                    }
                }
            });

            //Activation / desactivation de notification pour la tache courante dans la modal view
            jsRoutes.controllers.Login.utilisateurConnecte().ajax({
                success: function (utilisateur) {
                    //console.log($("#notifTache").attr("onclick"));
                    //console.log($("#notifTache").attr("onclick"));

                    // onclick=""
                    //$("#notifTache").attr("onclick")

                    jsRoutes.controllers.NotificationController.hasActiverNotification(idTache).ajax({
                        success: function (booleanString) {
                            if ($("#notifTache").hasClass('fa-bell-slash')) {
                                $("#notifTache").removeClass('fa-bell-slash');
                            } else {
                                $("#notifTache").removeClass('fa-bell');
                            }

                            if (booleanString == 'true') {
                                $("#notifTache").addClass('fa-bell');
                            }
                            else {
                                $("#notifTache").addClass('fa-bell-slash');
                            }
                        },
                        error: function (errorMessage) {
                            alert(errorMessage);
                        }
                    });

                    $("#notifTache").attr("onclick", "notifPopupTache(this" + "," + idTache + ")" + ";activerOuDesactiverNotification(" + idTache + "," + utilisateur.id + ")");
                    //activerOuDesactiverNotification(idTache,utilisateur.id);
                }
            });

            $('#modalModifierSupprimerTache').attr("onclick","afficherModalSupprimerTache("+idTache+")");
            $('#modalConsulterSupprimerTache').attr("onclick","afficherModalSupprimerTache("+idTache+")");

        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
    });

}

var changeDisablePropertyChargesFormulaireTache = function (boolean) {
    $('#formModifierChargeInitiale').prop('disabled', boolean);
    $('#formModifierChargeRestante').prop('disabled', boolean);
    $('#formModifierChargeConsommee').prop('disabled', boolean);
}

var changeDisablePropretyFormulaireModifierTache = function (boolean) {
    $("#formModifierNomTache-tdb").prop('disabled', boolean);
    $("#formModifierDescriptionTache-tdb").prop('disabled', boolean);
    $("#form-tache-predecesseur").prop('disabled', boolean);
    $("#form-tache-successeur").prop('disabled', boolean);
    $("#responsableTacheModifier").prop('disabled', boolean);
    $("#DD-modifier").prop('disabled', boolean);
    $("#DFTO-modifier").prop('disabled', boolean);
    $("#DFTA-modifier").prop('disabled', boolean);
    $('#interlocuteurs-modifier input').each(function () {
        $(this).prop('disabled', boolean);
    });
}

var modifierTache = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serialize();
    console.log(serialize);

    //IDTACHE
    var idTache = $('#formModifierTache').attr('value');

    //PREDECESSEUR
    var idPredecesseur = "";
    if ($('#form-tache-predecesseur').select2().val() != null) {
        idPredecesseur = $('#form-tache-predecesseur').select2().val()[0];
        console.log("idPredecesseur" + idPredecesseur);
    }

    var tabSuccesseurs = [];
    //SUCCESSEUR
    $("#form-tache-successeur option").each(function () {
        if ($(this).is(':selected')) {
            console.log("selected : " + $(this).val());
            tabSuccesseurs.push($(this).val());
        }
    });

    //RESPONSABLE DE TACHE
    var idResponsableTache = $('#responsableTacheModifier').select2().val()[0];
    console.log("idReponsableTache" + idResponsableTache);

    //INTERLOCUTEURS EXTERNES
    var nbInterlocuteurs = $("#interlocuteurs-modifier li").length;
    var tabInterlocuteurs = [];

    for (i = 0; i < nbInterlocuteurs; i++) {
        if ($("#checkbox-interlocuteur-" + i).is(':checked')) {
            console.log("checked : " + $("#checkbox-interlocuteur-" + i).attr('value'));
            tabInterlocuteurs.push($("#checkbox-interlocuteur-" + i).attr('value'));
        }
    }

    var dataToSend = serialize + "&id-tache=" + idTache + "&predecesseur=" + idPredecesseur;
    dataToSend += "&successeurs=";

    for (var i = 0; i < tabSuccesseurs.length; i++) {
        dataToSend += tabSuccesseurs[i] + ",";
    }

    dataToSend += "&responsable=" + idResponsableTache;

    dataToSend += "&interlocuteurs=";

    for (var i = 0; i < tabInterlocuteurs.length; i++) {
        dataToSend += tabInterlocuteurs[i] + ",";
    }

    console.log("Data SEND : " + dataToSend);
    //Ajax call submit form
    jsRoutes.controllers.DashboardController.modifierTache().ajax({
        data: dataToSend,
        success: function () {
            refreshProjectTable(idTache);
            jsRoutes.controllers.UtilisateurController.listTachesUtilisateurConnecte().ajax({
                success: function (taches) {
                    console.log("SUCCESS");
                    console.log("ListTaches a afficher : ");
                    console.log(taches);
                    $('#errorModifierTache').hide();
                    $('#dataTables-tdb-tache').dataTable().fnDestroy();
                    var tableDashboardBody = $('#dataTables-tdb-tache-body');
                    tableDashboardBody.empty();

                    var tableContent = "";
                    $.each(taches, function (i, tache) {
                        console.log('ta iiiiiii  '+ tache.projet.id + "  " + tache.projet.avancementGlobal);
                        jsRoutes.controllers.ProjetController.listProjetsUtilisateurConnecteResponsableTache().ajax({
                            success: function (projects) {
                                $.each(projects, function (i, projet) {
                                    console.log("LOG DEBUG");
                                    console.log($('.liste-projet').find('div[name="projet-' + projet.id + '"]').html());
                                    console.log("Avancement : "+projet.avancementGlobal);

                                    if (projet.avancementGlobal == 100) {
                                        $('.liste-projet').find('div[name="projet-' + projet.id + '"]').addClass("projet-finished-sidebar");
                                        $('.liste-projet').find('div[name="projet-' + projet.id + '"]').css("background-color","#0d8ddb").css("display","none").css("color","#FFF");
                                    }
                                    else {
                                        $('.liste-projet').find('div[name="projet-' + projet.id + '"]').removeClass("projet-finished-sidebar");
                                        $('.liste-projet').find('div[name="projet-' + projet.id + '"]').removeAttr('style');
                                    }
                                });
                            }
                        });
                        tableContent += ('<tr value="' + tache.id + '" onclick="afficherModalTache(this)" class="table-center">');
                        tableContent += ('<td class="tdb-td-tache td-modal" style="padding:0px ;" data-toggle="modal" data-target="#modal-tache">');
                        tableContent += ('<p class="tdb-id-tache">' + tache.idTache + '</p>');
                        tableContent += ('<p class="tdb-nom-tache">' + tache.nom + '</p>');
                        tableContent += ('</td>');

                        tableContent += ('<td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tache">' + tache.projet.nom + '</td>');

                        tableContent += ('<td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tache">' + tache.projet.client.nom + '</td>');

                        tableContent += ('<td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tache">' + tache.dateDebut + '</td>');

                        tableContent += ('<td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tache">');
                        tableContent += ('<p style="display:none ;">' + tache.dateFinTard + '</p>');
                        tableContent += ('<p class="tdb-nom-tache">' + tache.dateFinTot + '</p>');
                        tableContent += ('<p class="tdb-nom-tache">' + tache.dateFinTard + '</p>');
                        tableContent += ('</td>');

                        tableContent += ('<td class="td-modal" class="td-avancement" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tache">');

                        tableContent += ('<p style="display:none ;">');
                        if ((Math.round(tache.avancementTache * 100)) > 0 || (Math.round(tache.avancementTache * 100)) < 100) {
                            tableContent += ('0' + (Math.round(tache.avancementTache * 100)));
                        } else {
                            tableContent += ((Math.round(tache.avancementTache * 100)));
                        }
                        tableContent += ('</p>');

                        tableContent += ('<p class="row-initiale">' + messages("initial") + ' : ' + tache.chargeInitiale);
                        if (tache.projet.hasUniteJour) {
                            tableContent += (messages("day-first-letter"));
                        } else {
                            tableContent += (messages("week-first-letter"));
                        }
                        tableContent += ('</p>');

                        tableContent += ('<p class="row-restante">' + messages("remaining") + ' : ' + tache.chargeRestante);
                        if (tache.projet.hasUniteJour) {
                            tableContent += (messages("day-first-letter"));
                        } else {
                            tableContent += (messages("week-first-letter"));
                        }
                        tableContent += ('</p>');

                        tableContent += ('<div class="progress progress-bar-default">');
                        if ((Math.round(tache.avancementTache * 100)) == 0) {
                            tableContent += ('<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%;color:black;">');
                            tableContent += ('0%');
                            tableContent += ('</div>');
                        } else {
                            tableContent += ('<div class="progress-bar" role="progressbar" aria-valuenow="' + (Math.round(tache.avancementTache * 100)) + '" aria-valuemin="0" aria-valuemax="100" style="width: ' + (Math.round(tache.avancementTache * 100)) + '% ;">');
                            tableContent += ((Math.round(tache.avancementTache * 100)) + '%');
                            tableContent += ('</div>');
                        }
                        tableContent += ('</div>');

                        tableContent += ('<p class="row-consommee">' + messages("consumed") + ' : ' + tache.chargeConsommee);
                        if (tache.projet.hasUniteJour) {
                            tableContent += (messages("day-first-letter"));
                        } else {
                            tableContent += (messages("week-first-letter"));
                        }
                        tableContent += ('</p>');
                        tableContent += ('</td>');

                        tableContent += ('<td style="vertical-align:middle ;">');
                        if (tache.hasPredecesseur) {
                            tableContent += ('<div class="row">' + messages("predecessor") + ' : ' + tache.predecesseurIdTache + '</div>');
                        } else {
                            tableContent += ('<div class="row">' + messages("predecessor") + ' : ' + messages("none") + '</div>');
                        }

                        if (tache.hasSuccesseur) {

                            tableContent += ('<div class="row">' + messages("successors") + ' : <div class="btn-group">');
                            tableContent += ('<button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">');
                            tableContent += (tache.nbSuccesseurs + ' ' + messages("tasks-lower") + '<span class="caret"></span></button>');

                            tableContent += ('<ul class="dropdown-menu dropdown-menu-pert">');

                            $.each(tache.successeurs, function (i, successeur) {
                                tableContent += ('<li>' + successeur.idTache + '</li>');
                            });

                            tableContent += ('</ul></div></div>');
                        } else {
                            tableContent += ('<div class="row">' + messages("successors") + ' : ' + messages("none") + '</div>');
                        }
                        tableContent += ('</td>');

                        if (tache.hasResponsableActivateNotification) {
                            tableContent += ('<td class="icon-notif-tdb" style="vertical-align:middle ;"><a onclick="activerOuDesactiverNotification(' + tache.id + ', ' + tache.responsableTache.id + ')"><i id="notif-icon-tache-' + tache.id + '" class="fa fa-bell"></i></a></td>');
                        } else {
                            tableContent += ('<td class="icon-notif-tdb" style="vertical-align:middle ;"><a onclick="activerOuDesactiverNotification(' + tache.id + ', ' + tache.responsableTache.id + ')"><i id="notif-icon-tache-' + tache.id + '" class="fa fa-bell-slash-o"></i></a></td>');
                        }

                        tableContent += ('</tr>');
                    });

                    console.log(tableContent);
                    tableDashboardBody.append(tableContent);

                    $('#modal-tache').modal('toggle');


                    //TODO refresh all


                }
            });

        },
        error: function (errorMessage, codeErreur) {
            console.log(codeErreur + " " + errorMessage);
            $('#errorModifierTache').show();

        }
    });
}

function generateRowProjet(projet) {
    var list = "";
    list += ('<tr class="table-center cursor-pointer" value="' + projet.id + '">');
    list += ('<td style="vertical-align:middle ;">' + projet.nom + '</td>');
    list += ('<td style="vertical-align:middle ;">' + projet.client.nom + '</td>');
    list += ('<td style="vertical-align:middle ;"> </td>');
    list += ('<td style="vertical-align:middle ;"> <p style="display:none ;"></p>');
    list += ('<td style="vertical-align:middle;">' + messages("no") + '</td>');
    if (projet.unite == "JOUR") {
        list += ('<td class="td-avancement" style="vertical-align:middle ;">' +
        '<p style="display:none ;">' + projet.avancementGlobal + '</p>' +
        '<p class="row-initiale">' + messages("initial") + ' :' +
        projet.chargeInitiale + ' ' + messages("day-first-letter") + '</p> <p class="row-restante">' + messages("remaining") + ': ' + projet.chargeRestante + +messages("day-first-letter") + '</p>');
        list += ('<div class="progress progress-bar-default">');
        if (projet.avancementGlobal == 0) {
            list += ('<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%;color:black;"> 0% </div>');
        } else {
            list += ('<div class="progress-bar" role="progressbar" aria-valuenow="' + projet.avancementGlobal + '"aria-valuemin="0" aria-valuemax="100" style="width:' + projet.avancementGlobal + '% ;">' + projet.avancementGlobal + '% </div>');
        }
        list += ('</div>');
        list += ('<p class="row-consommee">' + messages("consumed") + ' : ' + projet.chargeConsommee + messages("day-first-letter") + ' </p>');
        list += ('</td>');
    } else if (projet.unite == "SEMAINE") {
        list += ('<td class="td-avancement" style="vertical-align:middle ;">' +
        '<p style="display:none ;">' + projet.avancementGlobal + '</p>' +
        '<p class="row-initiale">' + messages("initial") + ' :' +
        projet.chargeInitiale + ' ' + messages("week-first-letter") + '</p> <p class="row-restante">' + messages("remaining") + ' :' + projet.chargeRestante + +messages("week-first-letter") + '</p>');
        list += ('<div class="progress progress-bar-default">');
        if (projet.avancementGlobal == 0) {
            list += ('<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%;color:black;"> 0% </div>');
        } else {
            list += ('<div class="progress-bar" role="progressbar" aria-valuenow="' + projet.avancementGlobal + '"aria-valuemin="0" aria-valuemax="100" style="width:' + projet.avancementGlobal + '% ;">' + projet.avancementGlobal + '% </div>');
        }
        list += ('</div>');
        list += ('<p class="row-consommee">' + messages("consumed") + ': ' + projet.chargeConsommee + ' ' + messages("week-first-letter") + ' </p>');
        list += ('</td>');
    }

    list += ('<td class="td-btn-suppr" data-toggle="modal" data-target="#modal-confirmation-suppr-projet-admin" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>');
    list += ('</tr>');
    return list;
}

function generateErrorCreerProjet(errorMessage) {
    var messageDiv = messages("errors") + ' : ';

    if (errorMessage.responseJSON.nomProjetVide == true) {
        messageDiv += '<br> - ' + messages("nameProjetEmptyError");
    }
    else if (errorMessage.responseJSON.nomIncorrect == true) {
        messageDiv += '<br> - ' + messages("nameIncorrectError");
    }
    else if (errorMessage.responseJSON.nomProjetTropLong == true) {
        messageDiv += '<br> - ' + messages("nameProjetTooLongError");
    }
    if (errorMessage.responseJSON.dateThDebutProjetVide == true) {
        messageDiv += '<br> - ' + messages("startDateEmptyError");
    }
    if (errorMessage.responseJSON.dateThFinProjetVide == true) {
        messageDiv += '<br> - ' + messages("endDateEmptyError");
    }

    if (errorMessage.responseJSON.descriptionTropLong == true) {
        messageDiv += '<br> - ' + messages("descriptionTooLongError");
    }


    if (errorMessage.responseJSON.dateFinAvantDebut == true) {
        messageDiv += '<br> - ' + messages("incoherentDate");
    }

    if (errorMessage.responseJSON.parseError == true) {
        messageDiv += '<br> - ' + messages("incoherentDate");
    }
    if (errorMessage.responseJSON.saisir2Date == true) {
        messageDiv += '<br> - ' + messages("saisir2DateError");
    }
    if (errorMessage.responseJSON.projetExist == true) {
        messageDiv += '<br> - ' + messages("projetExistError");
    }


    return messageDiv;
}

var modifierProjet = function (div) {
    var id = $(div).attr("value");
    var form = "#" + $(div).attr("form");
    var serialize = $(form).serialize();
    var idBtn = "projet-modifier-btn-" + id;
    var priorite = $('#' + idBtn + ' .btn-active').attr('value');
    jsRoutes.controllers.ProjetController.modifierProjet(id).ajax({
        data: serialize + '&priorite=' + priorite,
        success: function (data) {
            $("#errorModifierProjetP-" + id).empty();
            $("#errorModifierProjet-" + id).hide();

            $("#successModifierProjetP-" + id).html(messages("project") + ' ' + data.nom + ' ' + messages("modified"));
            $("#successModifierProjet-" + id).show();
            setTimeout(function () {
                $("#successModifierProjet-" + id).hide();
            }, 4000);
            var div = "#div-consulterProjet-" + data.id;
            $(div).find('div[id=projetName]').html(messages("project") + ': ' + data.nom);
            $(div).find('div[id=projetPriorite]').html(data.priorite);
            $(div).find('textarea[id=descriptionProjet]').html(data.description);
            var nom = "projet-" + data.id;
            $('.liste-projet').find('div[name=' + nom + ']').find('div[class=sidebar-projet-nom]').html(data.nom);
            $('.liste-projet').find('div[name=' + nom + ']').find('div[class=sidebar-client-projet-priorite]').find('div[class=valeur]').html(data.prioriteProjetEtClient);
            //modif des valeurs de la div
            nom = "client-projet-" + data.id;

            $('.liste-projet-client').find('div[name=' + nom + ']').find('div[class=sidebar-projet-nom]').html(data.nom);
            $('.liste-projet-client').find('div[name=' + nom + ']').find('div[class=sidebar-projet-priorite]').find('div[class=valeur]').html(data.priorite);
        },
        error: function (error) {
            $("#successModifierProjet-" + id).hide();
            $("#successModifierProjetP-" + id).empty();

            var messageDiv = generateErrorModifierProjet(error);
            $("#errorModifierProjetP-" + id).html(messageDiv);
            console.log($("#errorModifierProjetP-" + id).html());
            $("#errorModifierProjet-" + id).show();
        }
    });
}

function generateErrorModifierProjet(errorMessage) {
    console.log(errorMessage);
    var messageDiv = messages("errors") + ' : ';

    if (errorMessage.responseJSON.nomProjetVide == true) {
        messageDiv += '<br> - ' + messages("nameProjetEmptyError");
    }
    else if (errorMessage.responseJSON.nomIncorrect == true) {
        messageDiv += '<br> - ' + messages("nameIncorrectError");
    }
    else if (errorMessage.responseJSON.nomProjetTropLong == true) {
        messageDiv += '<br> - ' + messages("nameProjetTooLongError");
    }

    if (errorMessage.responseJSON.descriptionTropLong == true) {
        messageDiv += '<br> - ' + messages("descriptionTooLongError");
    }

    if (errorMessage.responseJSON.projetExist == true) {
        messageDiv += '<br> - ' + messages("projetExistError");
    }
    return messageDiv;
}

var checkContactModal = function (btn) {
    var form = $(btn).attr("form");
    form = "#" + form;
    var serialize = $(form).serialize();
    jsRoutes.controllers.ClientController.contactCheck().ajax({
        data: serialize,
        success: function (data) {
            var $email = data.email;

            var $length = $('#table-modal-client-contacts-body tr > td:contains(' + $email + ')').length;
            if ($length > 0) {
                $("#successModifierClient").hide();
                $("#successModifierClientP").empty();
                var messageDiv = '<br> - /!\\ ' + messages("emailAlreadyUsed");
                $("#errorModifierClientP").html(messageDiv);
                $("#errorModifierClient").show();
            } else {
                $("#errorModifierClientP").empty();
                $("#errorModifierClient").hide();

                $("#successModifierClientP").html(messages("contact") + data.nom + ' ' + data.prenom + ' ' + messages("created"));
                $("#successModifierClient").show();


                setTimeout(function () {
                    $("#successModifierClient").hide();
                }, 4000);

                var contact = $('#table-modal-client-contacts-body');

                var list = "";
                list += ('<tr value=" ">');
                list += ('<td class="first-td">' + data.nom + '</td>');
                list += ('<td class="first-td">' + data.prenom + '</td>');
                list += ('<td style="display:none;">' + data.email + '</td>');
                list += ('<td style="display:none;">' + data.telephone + '</td>');
                list += ('<td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>');
                list += ('</tr>');
                contact.append(list);
                var size = listeNewContact.length;
                listeNewContact[size] = {};
                listeNewContact[size]["nom"] = data.nom;
                listeNewContact[size]["prenom"] = data.prenom;
                listeNewContact[size]["email"] = data.email;
                listeNewContact[size]["telephone"] = data.telephone;
                $(form)[0].reset();
            }
        },
        error: function (errorMessage) {
            $("#successModifierClient").hide();
            $("#successModifierClientPsuccessModifierClientP").empty();
            var messageDiv = generateErrorCreerClientContact(errorMessage);
            $("#errorModifierClientP").html(messageDiv);
            $("#errorModifierClient").show();
        }
    });
}


var modifierProjetAdminSelect = function (div) {
    var id = $(div).attr("value");
    var form = "#" + $(div).attr("form");
    var serialize = $(form).serialize();
    var priorite = $('#projet-modifierAdmin-btn .btn-active').attr('value');

    jsRoutes.controllers.AdminController.modifierProjet(id).ajax({
        data: serialize + '&priorite=' + priorite,
        success: function (data) {
            $("#errorModifierProjetP").empty();
            $("#errorModifierProjet").hide();

            $("#successModifierProjetP").html(messages("project") + ' ' + data.nom + ' ' + messages("modified"));
            $("#successModifierProjet").show();
            setTimeout(function () {
                $("#successModifierProjet").hide();
            }, 4000);

            // modification nom, responsable projet, priorite projet, priorite client


            $("#nomProjet").html(messages("project") + ': ' + data.nom);
            $("#prioriteProjet").html(data.priorite);
            $("#nomClient").html(messages("client") + ': ' + data.client.nom);
            $("#prioriteClient").html(data.client.priorite);
            $("#descriptionProjet").html(data.description);
            $("#responsableProjetName").html(messages("projectPersonResponsible") + ': ' + data.responsableProjet.prenom + ' ' + data.responsableProjet.nom);
        },
        error: function (error) {
            $("#successModifierProjet").hide();
            $("#successModifierProjetP").empty();

            var messageDiv = generateErrorModifierProjet(error);

            $("#errorModifierProjetP").html(messageDiv);
            $("#errorModifierProjet").show();
        }
    });
}


$(document).ready(function () {


    // Print the first selected project
    $('#' + $('.sidebar-projet.select').attr("name")).show();

    $('#checkbox-notif-all-selected').click(function () {
        if ($('#checkbox-notif-all-selected').is(':checked')) {
            $("div.checkbox-notif input[type=checkbox]").each(function () {
                var idNotif = $(this).attr('name');
                document.getElementById('checkbox-notif-' + idNotif).checked = true;
                clickOnCheckboxNotification('checkbox-notif-' + idNotif, 'notif-' + idNotif);
            });
        }
        else {
            $("div.checkbox-notif input[type=checkbox]").each(function () {
                var idNotif = $(this).attr('name');
                document.getElementById('checkbox-notif-' + idNotif).checked = false;
                clickOnCheckboxNotification('checkbox-notif-' + idNotif, 'notif-' + idNotif);
            });
        }
    });

    $('#dataTables-admin-user').DataTable({
        destroy: true,
        info:false,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 7,
        }]
    });


    $('#dataTables-admin-client').DataTable({
        destroy: true,
        info:false,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 6
        }]
    });

    $('#sidebar-back-select').click(function () {
        alert("JS : #sidebar-back-select");
    });

    $("#btn-modifierProjet-admin").click(function () {
        //$("#div-consulterProjet").css("display","none");

        jQuery.fx.off = true;
        $("#div-consulterProjet-admin").hide();
        $("#div-modifierProjet-admin").show();
        jQuery.fx.off = false;
    });

    function modeDraftProjetAdmin() {
        if ($('#checkbox-draft-projet-admin').is(':checked')) {
            $('#nestable-projet-admin').removeClass("dd-nodrag");
            $('.id-tache').hide();
        }
        else {
            $('#nestable-projet-admin').addClass("dd-nodrag");
            $('.id-tache').show();
        }
    }

    modeDraftProjetAdmin();
    $('#checkbox-draft-projet-admin').click(function () {
        modeDraftProjetAdmin();
    });

    $(".select2-input").select2();

    $(".select2-predecesseur").select2({
        placeholder: messages("choosePredecessor") + '...',
        maximumSelectionLength: 1
    });

    $(".select2-successeur").select2({
        placeholder: messages("chooseSuccessor") + '...'
    });
    $(".select2-client").select2({
        placeholder: messages("chooseClient") + '...',
        maximumSelectionLength: 1
    });

    $(".select2-respo-projet").select2({
        placeholder: messages("chooseProjectManager") + '...',
        maximumSelectionLength: 1
    });
    $(".select2-respo-tache").select2({
        placeholder: messages("chooseTaskResponsible") + '...',
        maximumSelectionLength: 1
    });

    $("#searchContact-select2").select2();


    $('.datatable-consulterClient').DataTable({
        destroy : true,
        info : false
    });
    $('.dataTables-example').DataTable();

    $('#projet_Tache').dataTable({
        destroy : true,
        info : false,
        "ordering": false
    });

    $('#projet_Projet').dataTable({
        destroy : true,
        info : false,
        "ordering": false
    });

    $('#dataTables-tdb-projet').DataTable({
        destroy : true,
        info:false
    });

    $('#dataTables-tdb-tache').DataTable({
        destroy : true,
        info : false,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": [6, 7]
        }]
    });

    $('#dataTables-admin-projet').DataTable({
        destroy : true,
        info : false,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 6
        }]
    });


    $('.nestable').nestable({
        group: 1,
        maxDepth: 4
    }).on('change');

    $('#btn-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').hide();
        $('#errorCreerTache').hide();
        $('#div-modifierTache').show();
        jQuery.fx.off = false;

    });

    $('#btn-fermer-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

    /*$('#btn-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });*/

    $('#btn-modifierTache-active').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').hide();
        $('#div-projet-modifierTache').show();
        jQuery.fx.off = false;

    });

    $('#btn-projet-fermer-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-modifierTache-active').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#datepicker_date_debut .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_tot .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tard .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });

    $('#datepicker_date_debutC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_totC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tardC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#projet-tdb').slimScroll({
        height: '130px'
    });
    $('#tache-tdb').slimScroll({
        height: '130px'
    });
    $('#taches-retardes').slimScroll({
        height: '130px'
    });
    $('#taches-proches').slimScroll({
        height: '130px'
    });
    $('#taches-proposees').slimScroll({
        height: '130px'
    });
    $('#bloc-notes-tdb').slimScroll({
        height: '172px',
        width: '100%'
    });
    $('.description-modal-tache').slimScroll({
        height: '100px'
    });

    $('.list-task').slimScroll({
        height: '90px'
    });
    $('.list-modif-client').slimScroll({
        height: '130px'
    });

    $('.list-personnes-notifiees').slimScroll({
        height: '85px'
    });

    $('[data-toggle="popover"]').popover();


    // Envoie de notification
    $(window).on('beforeunload', function () {
        jsRoutes.controllers.NotificationController.sendNotifications().ajax();
    });
});

$(document).on('click', '#errorCreerUser > button', function () {
    $("#errorCreerUser").hide()
});
$(document).on('click', '#errorCreerClient > button', function () {
    $("#errorCreerClient").hide()
});
$(document).on('click', '#errorCreerProjet > button', function () {
    $("#errorCreerProjet").hide()
});
$(document).on('click', '#errorModifierProjet > button', function () {
    $("#errorModifierProjet").hide()
});
$(document).on('click', '#errorModifierClient > button', function () {
    $("#errorModifierClient").hide()
});

$(document).on('click', '#submitButton', function () {
    var $form = $('#addProjectForm');
    var $serialize = $form.serialize();
    var $value = $("#btnCreerProjet .btn-active").attr('value');
    jsRoutes.controllers.ProjetController.creerProjet().ajax({
        data: $serialize + '&priorite=' + $value,
        success: function (data) {
            $("#errorCreerProjetP").empty();
            $("#errorCreerProjet").hide();
            $("#successCreerProjetP").html(messages("project") + ' ' + data.nom + ' ' + messages("created"));
            $("#successCreerProjet").show();
            setTimeout(function () {
                $("#successCreerProjet").hide();
            }, 4000);
            var projetList = $('#dataTables-admin-projet-body');
            $("#dataTables-admin-projet").dataTable().fnDestroy();
            var list = generateRowProjet(data);
            projetList.append(list);

            $("#addProjectForm")[0].reset();
        },
        error: function (errorMessage) {
            $("#successCreerProjet").hide();
            $("#successCreerProjetP").empty();

            var messageDiv = generateErrorCreerProjet(errorMessage);

            $("#errorCreerProjetP").html(messageDiv);
            $("#errorCreerProjet").show();
        }
    });

});

$(document).ajaxComplete(function () {

    // Print the first selected project
    $('#' + $('.sidebar-projet.select').attr("name")).show();

    $('#checkbox-notif-all-selected').click(function () {
        if ($('#checkbox-notif-all-selected').is(':checked')) {
            $("div.checkbox-notif input[type=checkbox]").each(function () {
                var idNotif = $(this).attr('name');
                document.getElementById('checkbox-notif-' + idNotif).checked = true;
                clickOnCheckboxNotification('checkbox-notif-' + idNotif, 'notif-' + idNotif);
            });
        }
        else {
            $("div.checkbox-notif input[type=checkbox]").each(function () {
                var idNotif = $(this).attr('name');
                document.getElementById('checkbox-notif-' + idNotif).checked = false;
                clickOnCheckboxNotification('checkbox-notif-' + idNotif, 'notif-' + idNotif);
            });
        }
    });

    $("#btn-modifierProjet-admin").click(function () {
        //$("#div-consulterProjet").css("display","none");

        jQuery.fx.off = true;
        $("#div-consulterProjet-admin").hide();
        $("#div-modifierProjet-admin").show();
        jQuery.fx.off = false;
    });


    $(".header-sidebar-projet").click(function () {

        if ($(this).next().is(":visible")) {
            next = $(this).next();
            while (next != null && next.hasClass("client-project")) {
                next.hide();
                next = next.next();
            }
        }
        else {
            next = $(this).next();
            while (next != null && next.hasClass("client-project")) {
                next.show();
                next = next.next();
            }
        }

        $('.liste-projet-client').css('height', "100%");
        height = $('.liste-projet-client').css('height');
        height = parseInt(height);
        height -= 200;
        $('.liste-projet-client').css('height', height);

    });

    $(window).resize(function () {
        $('.liste-projet-client').css('height', "100%");
        height = $('.liste-projet-client').css('height');
        height = parseInt(height);
        height -= 200;
        $('.liste-projet-client').css('height', height);
    });

    $('.liste-projet-client').css('height', "100%");
    height = $('.liste-projet-client').css('height');
    height = parseInt(height);
    height -= 200;
    $('.liste-projet-client').css('height', height);


    $('.sidebar-projet').click(function () {
        var idProjet = '#' + $('.sidebar-projet.select').attr("name");
        $('.sidebar-projet.select').removeClass("select");
        $(idProjet).hide();
        $(this).addClass("select");
        var newIdProjet = '#' + $(this).attr("name");
        $(newIdProjet).show();
        updateTaskNestableCheckbox($('.sidebar-projet.select').attr("projet"));
    });


    $(window).resize(function () {
        $('.liste-projet').css('height', "100%");
        height = $('.liste-projet').css('height');
        height = parseInt(height);
        height -= 150;
        $('.liste-projet').css('height', height);
        $('.liste-projet-client').css('height', "100%");
        height = $('.liste-projet-client').css('height');
        height = parseInt(height);
        height -= 200;
        $('.liste-projet-client').css('height', height);


        if ($(window).width() < 750) {

            hideSideBarProjet();
            $('.liste-projet-client').css('height', "100%");
            height = $('.liste-projet-client').css('height');
            height = parseInt(height);
            height -= 200;
            $('.liste-projet-client').css('height', height);

        }
        else {

            showSideBarProjet();
            $('.liste-projet-client').css('height', "100%");
            height = $('.liste-projet-client').css('height');
            height = parseInt(height);
            height -= 200;
            $('.liste-projet-client').css('height', height);

        }
    });


    $('.liste-projet').css('height', "100%");
    height = $('.liste-projet').css('height');
    height = parseInt(height);
    height -= 150;
    $('.liste-projet').css('height', height);


    $(".select2-predecesseur").select2({
        placeholder: messages("choosePredecessor") + '...',
        maximumSelectionLength: 1
    });

    $(".select2-successeur").select2({
        placeholder: messages("chooseSuccessor") + '...'
    });
    $(".select2-client").select2({
        placeholder: messages("chooseClient") + '...',
        maximumSelectionLength: 1
    });

    $(".select2-respo-projet").select2({
        placeholder: messages("chooseProjectManager") + '...',
        maximumSelectionLength: 1
    });
    $(".select2-respo-tache").select2({
        placeholder: messages("chooseTaskResponsible") + '...',
        maximumSelectionLength: 1
    });

    $('#unite').select2({
        minimumResultsForSearch: -1
    });
    $('#unite-projet').select2({
        minimumResultsForSearch: -1
    });

    $('[data-toggle="popover"]').popover();
    // activate Nestable for list 1

    $('.nestable').nestable({
        group: 1,
        maxDepth: 4
    }).on('change');

    if (!($.fn.dataTable.isDataTable('.datatable-consulterClient'))) {
        $('.datatable-consulterClient').DataTable({
            destroy : true,
            info : false
        });
    }

    if (!($.fn.dataTable.isDataTable('#dataTables-tdb-projet'))) {
        $('#dataTables-tdb-projet').DataTable({
            destroy : true,
            info : false
        });
    }

    if (!($.fn.dataTable.isDataTable('#dataTables-tdb-tache'))) {
        $('#dataTables-tdb-tache').DataTable({
            destroy : true,
            info : false,
            "columnDefs": [{
                "searchable": false,
                "orderable": false,
                "targets": [6, 7]
            }]
        });
    }

    if (!($.fn.dataTable.isDataTable('#dataTables-admin-user'))) {
        $('#dataTables-admin-user').DataTable({
            destroy : true,
            info : false,
            "columnDefs": [{
                "searchable": false,
                "orderable": false,
                "targets": 7,
            }]
        });
    }



    $('#responsableProjet').select2();

    $('#client').select2();

    $('#responsableProjet-projet').select2();

    $('#client-projet').select2();

    $('.dataTables-example').DataTable({
    });

    if (!($.fn.dataTable.isDataTable('#projet_Projet'))) {
        $('#projet_Projet').DataTable({
            destroy: true,
            info : false,
            "ordering": false
        });
    }

    if (!($.fn.dataTable.isDataTable('#dataTables-admin-projet'))) {
        $('#dataTables-admin-projet').DataTable({
            destroy: true,
            info : false,
            "columnDefs": [{
                "searchable": false,
                "orderable": false,
                "targets": 6
            }]
        });
    }

    if (!($.fn.dataTable.isDataTable('#projet_Tache'))) {
        $('#projet_Tache').DataTable({
            destroy : true,
            info : false,
            "ordering": false
        });
    }

    if (!($.fn.dataTable.isDataTable('#dataTables-admin-client'))) {
        $('#dataTables-admin-client').DataTable({
            destroy: true,
            info : false,
            "columnDefs": [{
                "searchable": false,
                "orderable": false,
                "targets": 6
            }]
        });
    }

    $('#btn-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').hide();
        $('#div-modifierTache').show();
        jQuery.fx.off = false;

    });

    $('#btn-fermer-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

    /*$('#btn-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;
    });*/

    $('#btn-modifierTache-active').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').hide();
        $('#div-projet-modifierTache').show();
        jQuery.fx.off = false;

    });

    $('#btn-projet-fermer-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-projet-modifierTache-active').click(function () {
        jQuery.fx.off = true;
        $('#div-projet-consulterTache').show();
        $('#div-projet-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#datepicker_date_debut .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"


    });

    $('#datepicker_date_fin_tot .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR",

    });

    $('#datepicker_date_fin_tard .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_debutC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_totC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tardC .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });


    $('#datepicker_projet_th_debut-projet .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });

    $('#datepicker_projet_th_fin-projet .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });

    $('#datepicker_projet_th_debut .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr"
    });

    $('#datepicker_projet_th_fin .input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr"
    });

    $('#projet-tdb').slimScroll({
        height: '130px'
    });
    $('#tache-tdb').slimScroll({
        height: '130px'
    });
    $('#taches-retardes').slimScroll({
        height: '130px'
    });
    $('#taches-proches').slimScroll({
        height: '130px'
    });
    $('#taches-proposees').slimScroll({
        height: '130px'
    });
    $('#bloc-notes-tdb').slimScroll({
        height: '172px',
        width: '100%'
    });
    $('.description-modal-tache').slimScroll({
        height: '100px'
    });

    $('.list-task').slimScroll({
        height: '90px'
    });
    $('.list-modif-client').slimScroll({
        height: '130px'
    });

    $('.list-personnes-notifiees').slimScroll({
        height: '85px'
    });
    /*
     $('.table-suppr-user').slimScroll({
     height: '300px'
     });
     */

    $('.footable').footable();

    function modeDraftProjetAdmin() {
        if ($('#checkbox-draft-projet-admin').is(':checked')) {
            $('#nestable-projet-admin').removeClass("dd-nodrag");
            $('.id-tache').hide();
        }
        else {
            $('#nestable-projet-admin').addClass("dd-nodrag");
            $('.id-tache').show();
        }
    }

    modeDraftProjetAdmin();
    $('#checkbox-draft-projet-admin').click(function () {
        modeDraftProjetAdmin();
    });

    // Envoie de notification
    $(window).on('beforeunload', function () {
        jsRoutes.controllers.NotificationController.sendNotifications().ajax();
    });
});


var interval;
function callAjaxNbNotificationsNonLues() {
    jsRoutes.controllers.NotificationController.nbNotificationsNonLues().ajax({
        success: function (data) {
            if (parseInt(data) > 0) {
                $("#nbNotifNonLues-topbar").html(data);
                $("#nbNotifNonLues-topbar").show();
            } else {
                $("#nbNotifNonLues-topbar").hide();
            }

            interval = setTimeout(callAjaxNbNotificationsNonLues, 10000);
        }
    });
}
callAjaxNbNotificationsNonLues();