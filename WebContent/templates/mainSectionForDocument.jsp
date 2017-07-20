<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
				<h2>{{document.title}}</h2>
				<p>{{document.details}}</p>
				<p>Master document: {{document.masterDocument.title}}</p>
				<h2>{{document.title}} > Sections:</h2>
				<div class="collection deep-orange lighten-4 black-text" id="doc-list" ng-repeat="section in sectionsAndContent">
					<div class="collection-item avatar text-lighten-3 deep-orange lighten-4">
					<a href="/DMS/#/sec/{{section.data.id}}"> <span class="title doc-title">{{section.data.title}}</span><br>
						<span>{{section.value.paragraphs[0].html | cut:true:250:'...'}}
					</span></a></div>					
			        <div id="space">
			
			        </div>
		        </div>