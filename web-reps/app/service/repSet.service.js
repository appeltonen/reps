angular.module('dataService', [])
    .service('repSetService', repSetService);

function repSetService($http, AppConfig) {
    var repSetUrl = _.join([AppConfig.API_URL, 'rep-set'], '/');

    function deleteRepSet(repSet) {
        return $http({
            method: 'DELETE',
            url: repSetUrl,
            headers: {
            'Content-Type': 'application/json'
            },
            data: repSet
        });
    }

    function getRepSets() {
        return $http.get(repSetUrl);
    }

    function saveRepSet(repSet) {
        return $http.post(repSetUrl, repSet);
    }

    return {
        get: getRepSets,
        save: saveRepSet,
        delete: deleteRepSet
    }
}