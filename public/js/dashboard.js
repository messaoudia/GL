/**
 * Created by Guillaume on 03/03/2016.
 */
var modifierTache = function (btn) {
    var form = $(btn).attr("form");
    form = "#"+form;
    var serialize = $(form).serialize();
    console.log(serialize);

    //IDTACHE
    var idTache = $('#formModifierTache').attr('value');

    //PREDECESSEUR
    var idPredecesseur = $('#form-tache-predecesseur').select2().val()[0];
    console.log("idPredecesseur"+idPredecesseur);

    var tabSuccesseurs = [];
    //SUCCESSEUR
    $("#form-tache-successeur option").each(function() {
        if($(this).is(':selected')){
            console.log("selected : "+$(this).val());
            tabSuccesseurs.push($(this).val());
        }
    });

    //RESPONSABLE DE TACHE
    var idResponsableTache = $('#responsableTacheModifier').select2().val()[0];
    console.log("idReponsableTache"+idResponsableTache);

    //INTERLOCUTEURS EXTERNES
    var nbInterlocuteurs = $("#interlocuteurs-modifier li").length;
    var tabInterlocuteurs = [];

    for (i = 0; i < nbInterlocuteurs; i++) {
        if($("#checkbox-interlocuteur-"+i).is(':checked')){
            console.log("checked : "+$("#checkbox-interlocuteur-"+i).attr('value'));
            tabInterlocuteurs.push($("#checkbox-interlocuteur-"+i).attr('value'));
        }
    }

    var dataToSend = serialize+"&id-tache="+idTache+"&predecesseur="+idPredecesseur;
    dataToSend += "&successeurs=";

    for (var i = 0; i < tabSuccesseurs.length; i++){
        dataToSend += tabSuccesseurs[i]+",";
    }

    dataToSend += "&responsable="+idResponsableTache;

    dataToSend += "&interlocuteurs=";

    for (var i = 0; i < tabInterlocuteurs.length; i++){
        dataToSend += tabInterlocuteurs[i]+",";
    }

    console.log("Data SEND : "+dataToSend);
    //Ajax call submit form
    jsRoutes.controllers.DashboardController.modifierTache().ajax({
        data: dataToSend,
        success : function(data) {
            console.log("SUCCESS");
        },
        error: function(errorMessage,codeErreur){
            console.log(codeErreur+" "+errorMessage);
        }

    });
}