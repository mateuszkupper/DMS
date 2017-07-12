				<h2>Your documents:</h2>
				<div class="collection deep-orange lighten-4" id="doc-list"  ng-repeat="document in documents">
					<div class="collection-item avatar text-lighten-3 deep-orange lighten-4">
						<a href="#!"> 
							<span class="title doc-title"># {{document.id}}</span><br>
							<span>{{document.title}}</span>
						</a>
					</div>					
			        <div id="space">
			
			        </div>
				</div>