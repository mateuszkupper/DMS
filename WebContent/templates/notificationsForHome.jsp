				<h2>Notifications:</h2>
				<div class="collection">
					<a class="collection-item avatar black-text text-lighten-3" href="#!" ng-repeat="notification in notifications"> 
						<span class="title">Master:{{notification.sectionMaster.document.title}} > {{notification.sectionMaster.title}}
						</span><br> <span>Slave: {{notification.sectionSlave.document.title}} > {{notification.sectionSlave.title}}<br>
						{{notification.details}}
						</span>
					</a>
				</div>