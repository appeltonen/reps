angular.module('repSetEditor', ['repEditor'])
    .component('repSetEditor', {
        bindings: {
            repSet: '<',
            onDelete: '&'
        },
        controller: repSetEditorController,
        templateUrl: 'component/repSetEditor.tpl.html'
    });

function repSetEditorController() {
    var ctrl = this;

    ctrl.$onInit = function() {
      ctrl.name = repSetName(ctrl.repSet.id);
      ctrl.reps = ctrl.repSet.reps;
      ctrl.editable = ctrl.repSet.id === undefined;
    };

    function addRep() {
        ctrl.reps.push({times: 0});
    }

    function copy(rep) {
        ctrl.reps.push(_.clone(rep));
    }

    function deleteRepSet() {
        ctrl.onDelete({repSetToDelete: ctrl.repSet});
    }

    function repSetName(id) {
        return id === undefined ? 'New rep set' : 'Rep set #' + ctrl.repSet.id;
    }

    ctrl.addRep = addRep;
    ctrl.copy = copy;
    ctrl.delete = deleteRepSet;
}