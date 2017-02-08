/*-
 * ================================================================================
 * DCAE DMaaP Bus Controller Web Application
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ================================================================================
 */
app.controller("droolsListController", function ($scope,$http,droolsService, modalService, $modal) { 
	// Table Data
	droolsService.getDrools().then(function(data){
		
		var j = data;
  		$scope.tableData = JSON.parse(j.data);
  		//$scope.resetMenu();
	
	},function(error){
		console.log("failed");
		reloadPageOnce();
	});
	
	$scope.viewPerPage = 20;
    $scope.scrollViewsPerPage = 2;
    $scope.currentPage = 1;
    $scope.totalPage;
    $scope.searchCategory = "";
    $scope.searchString = "";
 /*    modalService.showSuccess('','Modal Sample') ; */
	for(x in $scope.tableData){
		if($scope.tableData[x].active_yn=='Y')
			$scope.tableData[x].active_yn=true;
		else
			$scope.tableData[x].active_yn=false;
	}
    $scope.openDialog = function(droolFile){
    	droolsService.setSelectedFile(droolFile);
    	$modal.open({
            templateUrl: 'app/fusionapp/drools/view-models/droolsView.html',
            controller: 'droolsViewController'
          
        })
    }
   

   
});

function openInNewTab(url) {
	  var win = window.open(url, '_blank');
	  win.focus();
};
