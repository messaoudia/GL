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

            $("#successModifierUserP").html(messages("user") + ' ' + utilisateur.nom + ' ' + utilisateur.prenom + ' ' + messages("created"));
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

            $("#successModifierClientP").html(messages("client") + data.nom + messages("modified"));
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

            $("#successCreerClientP").html(messages("client") + data.nom + messages("created"));
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
            $("#successCreerClient").hide();
            $("#successCreerClientP").empty();

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
    list += ('<td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">messages("no")</td>');
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
    else if (errorMessage.responseJSON.nomClientIncorrecte == true) {
        messageDiv += '<br> - ' + messages("nameClientIncorrectError");
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
    else if (errorMessage.responseJSON.nomTropLongContact == true) {
        messageDiv += '<br> - ' + messages("lastnameTooLongError");
    }
    else if (errorMessage.responseJSON.nomIncorrectContact == true) {
        messageDiv += '<br> - ' + messages("lastnameIncorrectError");
    }

    if (errorMessage.responseJSON.prenomVideContact == true) {
        messageDiv += '<br> - ' + messages("firstnameEmptyError");
    }
    else if (errorMessage.responseJSON.prenomTropLongContact == true) {
        messageDiv += '<br> - ' + messages("firstnameTooLongError");
    }
    else if (errorMessage.responseJSON.prenomIncorrectContact == true) {
        messageDiv += '<br> - ' + messages("firstnameIncorrectError");
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
                            list += '<option value="' + t.id + '" selected>' + t.id + ' - ' + t.nom + '</option>';
                        }
                        else {
                            list += '<option value="' + t.id + '">' + t.id + ' - ' + t.nom + '</option>';
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
                            list += '<option value="' + t.id + '" selected>' + t.id + ' - ' + t.nom + '</option>';
                        } else {
                            list += '<option value="' + t.id + '">' + t.id + ' - ' + t.nom + '</option>';
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
                $('#table-predecesseurTache-consulter-tdb table tbody tr .id-task').html(tache.predecesseurId);
                $('#table-predecesseurTache-consulter-tdb table tbody tr .name-task').html(tache.predecesseurNom);

                console.log('#predecesseurTache-' + tache.predecesseurId);

            }
            /*console.log("tache = "+JSON.stringify(tache))
             console.log("predecesseurNom : "+tache.predecesseurNom);
             console.log("predecesseurId : "+tache.predecesseurId);
             console.log("Successeurs : "+tache.successeurs);*/

            var list = "";
            var listModifier = "";
            if (tache.successeurs) {
                $(tache.successeurs).each(function (index, tache) {
                    list += '<tr>';
                    list += '<td class="id-task">' + tache.id + '</td>';
                    list += '<td class="name-task">' + tache.nom + '</td>';
                    list += '</tr>';
                });
            }
            $('#table-successeursTache-consulter-tdb-body').html(list);

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
            $('#nbJourRestant').html(messages("remainingTime") + tache.nbJourRestant + messages("day-first-letter"));
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
            $('#chargeConsommeeTache').html(+essages("consumed") + ': ' + tache.chargeConsommee + unite);
            $('#formModifierChargeInitiale').attr("value", tache.chargeInitiale);
            $('#formModifierChargeInitiale').nextAll('span').html(unite);
            if (tache.disponible) {
                $('.formModifierChargeRestante').attr("disabled", false);
                $('.formModifierChargeConsommee').attr("disabled", false);
            } else {
                $('.formModifierChargeRestante').attr("disabled", true);
                $('.formModifierChargeConsommee').attr("disabled", true);
            }
            $('#formModifierChargeRestante').attr("value", tache.chargeRestante);
            $('#formModifierChargeRestante span').nextAll('span').html(unite);
            $('#formModifierChargeConsommee').attr("value", tache.chargeConsommee);
            $('#formModifierChargeConsommee span').nextAll('span').html(unite);

            if (!tache.disponible) {
                $('#formModifierChargeInitiale').attr("disabled", "");
                $('#formModifierChargeRestante').attr("disabled", "");
                $('#formModifierChargeConsommee').attr("disabled", "");
            }
            else {
                $('#formModifierChargeInitiale').removeAttr("disabled");
                $('#formModifierChargeRestante').removeAttr("disabled");
                $('#formModifierChargeConsommee').removeAttr("disabled");
            }

        },
        //Case we have a problem
        error: function (errorMessage) {
            alert(errorMessage);
        }
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

            jsRoutes.controllers.UtilisateurController.listTachesUtilisateurConnecte().ajax({
                success: function (taches) {
                    console.log("SUCCESS");
                    console.log("ListTaches a afficher : ");
                    console.log(taches);

                    $('#dataTables-tdb-tache').dataTable().fnDestroy();

                    var tableDashboardBody = $('#dataTables-tdb-tache-body');
                    tableDashboardBody.empty();

                    var tableContent = "";
                    $.each(taches, function (i, tache) {
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
                            tableContent += (+essages("day-first-letter"));
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

                }
            });

        },
        error: function (errorMessage, codeErreur) {
            console.log(codeErreur + " " + errorMessage);
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
    return messageDiv;
}

var modifierProjet = function (div) {
    var id = $(div).attr("value");
    var form = "#" + $(div).attr("form");
    alert(form);
    var serialize = $(form).serialize();
    var idBtn = "projet-modifier-btn-" + id;
    var priorite = $('#' + idBtn + ' .btn-active').attr('value');

    alert(priorite);
    jsRoutes.controllers.ProjetController.modifierProjet(id).ajax({
        data: serialize + '&priorite=' + priorite,
        success: function (data) {
            $("#errorModifierProjetP").empty();
            $("#errorModifierProjet").hide();

            $("#successModifierProjetP").html(messages("project") + ' ' + data.nom + ' ' + messages("modified"));
            $("#successModifierProjet").show();
            setTimeout(function () {
                $("#successModifierProjet").hide();
            }, 4000);
            var div = "#div-consulterProjet-" + data.id;
            $(div).find('div[id=projetName]').html(messages("project") + ': ' + data.nom);
            $(div).find('div[id=projetPriorite]').html(data.priorite);
            $(div).find('textarea[id=descriptionProjet]').html(data.description);
            var nom = "projet-" + data.id;
            $('.liste-projet').find('div[name=' + nom + ']').find('div[class=sidebar-projet-nom]').html(data.nom);
            $('.liste-projet').find('div[name=' + nom + ']').find('div[class=sidebar-client-projet-priorite]').find('div[class=valeur]').html(data.prioriteProjetEtClient);
            //modif des valeurs de la div
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

function generateErrorModifierProjet(errorMessage) {
    var messageDiv = messages("errors") + ' : ';

    if (errorMessage.responseJSON.nomProjetVide == true) {
        messageDiv += '<br> - ' + messages("nameProjetEmptyError");
    }
    else if (errorMessage.responseJSON.nomProjetTropLong == true) {
        messageDiv += '<br> - ' + messages("nameProjetTooLongError");
    }

    if (errorMessage.responseJSON.descriptionTropLong == true) {
        messageDiv += '<br> - ' + messages("descriptionTooLongError");
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
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 7,
        }]
    });


    $('#dataTables-admin-client').DataTable({
        destroy: true,
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

    $("#btn-cancel-modifierProjet-admin").click(function () {
        jQuery.fx.off = true;
        $("#div-modifierProjet-admin").hide();
        $("#div-consulterProjet-admin").show();
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


    $('.datatable-consulterClient').DataTable();
    $('.dataTables-example').DataTable();

    $('#projet_Tache').dataTable({
        "ordering": false
    });

    $('#projet_Projet').dataTable({
        "ordering": false
    });

    $('#dataTables-tdb-projet').DataTable();

    $('#dataTables-tdb-tache').DataTable({
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": [6, 7]
        }]
    });

    $('#dataTables-admin-projet').DataTable({
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
        $('#div-modifierTache').show();
        jQuery.fx.off = false;

    });

    $('#btn-fermer-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

    $('#btn-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

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
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_tot .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tard .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });

    $('#datepicker_date_debutC .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_totC .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tardC .input-group.date').datepicker({
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

$(document).on('click', '#submitButton', function () {
    var $form = $('#addProjectForm');
    var $serialize = $form.serialize();
    var $value = $("#btnCreerProjet .btn-active").attr('value');
    jsRoutes.controllers.ProjetController.creerProjet().ajax({
        data: $serialize + '&priorite=' + $value,
        success: function (data) {
            $("#errorCreerProjetP").empty();
            $("#errorCreerProjet").hide();
            $("#successCreerProjetP").html(messages("projet") + ' ' + data.nom + ' ' + messages("created"));
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

    $("#errorCreerUser > button").click(function () {
        $("#errorCreerUser").hide()
    });

    $("#errorCreerClient > button").click(function () {
        $("#errorCreerClient").hide()
    });

    $("#errorCreerProjet > button").click(function () {
        $("#errorProjet").hide()
    });


    $("#btn-modifierProjet-admin").click(function () {
        //$("#div-consulterProjet").css("display","none");

        jQuery.fx.off = true;
        $("#div-consulterProjet-admin").hide();
        $("#div-modifierProjet-admin").show();
        jQuery.fx.off = false;
    });

    $("#btn-cancel-modifierProjet-admin").click(function () {
        jQuery.fx.off = true;
        $("#div-modifierProjet-admin").hide();
        $("#div-consulterProjet-admin").show();
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

    });


    $('#afficheRetour').click(function () {

        if ($("#col-sidebar-retour").is(":visible")) {
            hideSideBarRetour();
        }
        else {
            showSideBarRetour();
        }
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

    $('.datatable-consulterClient').DataTable();
    $('#dataTables-tdb-projet').DataTable();


    $('#dataTables-tdb-tache').DataTable({
        destroy: true,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": [6, 7]
        }]
    });

    $('#dataTables-admin-user').DataTable({
        destroy: true,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 7,
        }]
    });

    $('#responsableProjet').select2();

    $('#client').select2();

    $('#responsableProjet-projet').select2();

    $('#client-projet').select2();

    $('.dataTables-example').DataTable();

    $('#projet_Projet').dataTable({
        destroy: true,
        "ordering": false
    });

    $('#dataTables-admin-projet').DataTable({
        destroy: true,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 6
        }]
    });

    $('#projet_Tache').dataTable({
        "ordering": false
    });


    $('#dataTables-admin-client').DataTable({
        destroy: true,
        "columnDefs": [{
            "searchable": false,
            "orderable": false,
            "targets": 6
        }]
    });


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

    $('#btn-valider-modifierTache').click(function () {
        jQuery.fx.off = true;
        $('#div-consulterTache').show();
        $('#div-modifierTache').hide();
        jQuery.fx.off = false;

    });

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
        format: 'dd/mm/yy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"


    });

    $('#datepicker_date_fin_tot .input-group.date').datepicker({
        format: 'dd/mm/yy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR",

    });

    $('#datepicker_date_fin_tard .input-group.date').datepicker({
        format: 'dd/mm/yy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_debutC .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });
    $('#datepicker_date_fin_totC .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });
    $('#datepicker_date_fin_tardC .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"
    });


    $('#datepicker_projet_th_debut-projet .input-group.date').datepicker({
        format: 'dd/mm/yy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });

    $('#datepicker_projet_th_fin-projet .input-group.date').datepicker({
        format: 'dd/mm/yy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr-FR"

    });

    $('#datepicker_projet_th_debut .input-group.date').datepicker({
        //format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true,
        language: "fr"

    });

    $('#datepicker_projet_th_fin .input-group.date').datepicker({
        //format: 'dd/mm/yyyy',
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