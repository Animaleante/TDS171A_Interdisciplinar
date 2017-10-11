var DeleteItem = function (route) {
    var self = this;

    self.route = route;

    self.bindEvents();
};

DeleteItem.prototype.bindEvents = function () {
    var self = this;

    $(document).on('click', '.delete-item', function () {
        var itemId = $(this).attr('data-item-id');
        $('.btn-confirm-deleting').attr('data-item-id', itemId);
        $('#confirm-deleting-modal').modal('show');
    });

    $(document).on('click', '.btn-confirm-deleting', function () {
        var itemId = $(this).attr('data-item-id');
        window.location.href = self.route + '/' + itemId;
    });
};