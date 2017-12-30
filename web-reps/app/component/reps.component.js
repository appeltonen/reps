angular.module('workout', ['dataService', 'repSetEditor'])
    .component('reps', {
        bindings: {},
        templateUrl: 'component/reps.tpl.html',
        controller: repsController
    });

function repsController($log, repSetService) {
    var ctrl = this,
        editing;

    ctrl.$onInit = initController;
    ctrl.addRepSet = addRepSet;
    ctrl.cancel = cancel;
    ctrl.toggleEditing = toggleEditing;
    ctrl.saveRepSet = saveRepSet;
    ctrl.deleteRepSet = deleteRepSet;

    function addRepSet() {
        toggleEditing();
        ctrl.repSets.push(emptyRepSet());
    }

    function cancel() {
        ctrl.repSets = _.dropRight(ctrl.repSets);
        toggleEditing();
    }

    function deleteRepSet(repSet) {
        repSetService.delete(repSet).then(function(){
            _.pull(ctrl.repSets, repSet);
            update();
        });
    }

    function emptyRepSet() {
        return {
            reps: [{times: 0}]
        }
    }

    function initController() {
        repSetService.get().then(setupVmProps)
    }

    function update() {
        ctrl.showNotification = _.isEmpty(ctrl.repSets);
    }

    function saveRepSet() {
        var repSetToSave = _.last(ctrl.repSets);
        if(!editing) {
            return;
        }
        repSetService.save(repSetToSave).then(
            function(reponse){
                _.pull(ctrl.repSets, repSetToSave);
                ctrl.repSets.push(reponse.data);
                toggleEditing();
            },
            function(e) {
                $log.error('Error sasving rep set', e);
            });
    }

    function setCtrlEditingProp(newValue) {
        ctrl.editing = newValue;
    }

    function toggleEditing() {
        editing = !editing;
        setCtrlEditingProp(editing);
    }

    function setNotification(notification) {
        ctrl.notification = notification;
    }

    function setupVmProps(response) {
        ctrl.repSets = response.data;
        editing = false;
        setCtrlEditingProp(editing);
        ctrl.notificationPlaceholder = 'Add some reps to your workout';
        setNotification(ctrl.notificationPlaceholder);
        update();
    }
}


