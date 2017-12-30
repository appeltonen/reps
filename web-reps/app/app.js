'use strict';
angular.module('repsApp', ['workout'])
    .constant('AppConfig', {
        API_URL: 'http://localhost:8080'
    })
    .factory('_', lodashFactory)
    .controller('appCtrl', function() {
        var ctrl = this;
        ctrl.title = 'Reps';
    });

function lodashFactory($window) {
    return $window._;
}

lodashFactory.$inject = ['$window'];

