/**
 * Created by Guillaume on 07/03/2016.
 */

var afficherModalSupprimerTache = function(idTache){
    console.log("MODAL SUPPRIMER TACHE OK : "+idTache);

    $('#modal-confirmation-suppr-tache-projet').modal('show');
    $('#modal-confirmation-suppr-tache-projet').attr('data-id',idTache);

    jsRoutes.controllers.TacheController.getTacheById(idTache).ajax({
        success : function(tache){
            $('.taskNameDelete').html(tache.nom);
        }
    });
};

var supprimerTache = function(){
    var idTache = $('#modal-confirmation-suppr-tache-projet').attr('data-id');
    jsRoutes.controllers.TacheController.getTacheById(idTache).ajax({
        success : function(tache){
            jsRoutes.controllers.TacheController.supprimerTache(tache.id).ajax({
                success : function(){
                    //refresh all
                    refreshProjectTableByIdProject(tache.projet.id);
                },
                error : function(error, code){

                }
            });
        }
    });
}