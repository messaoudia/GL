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