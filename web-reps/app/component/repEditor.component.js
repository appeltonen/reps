angular.module('repEditor', [])
    .component('repEditor', {
        bindings: {
            rep: '<',
            editable: '<'
        },
        controller: repEditorController,
        templateUrl: 'component/repEditor.tpl.html'
    });

function repEditorController() {
    var ctrl = this;

    ctrl.$onInit = initController;

    function add() {
        ctrl.rep.times = _.add(ctrl.rep.times, 1);
    }

    function initController() {
        if(ctrl.editable !== undefined){
            ctrl.add = add;
            ctrl.subtract = subtract;
        }
    }

    function subtract() {
        if(ctrl.rep.times === 0) {
            return;
        }
        ctrl.rep.times = _.subtract(ctrl.rep.times, 1);
    }
}