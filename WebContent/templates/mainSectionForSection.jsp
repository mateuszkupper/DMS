<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
				<h2>{{section.document.title}} > {{section.title}}</h2>
				<p>{{section.document.details}}</p>	
				<h2>{{section.document.title}} > {{section.title}} > Paragraphs:</h2>

				<ul class="collapsible popout black-text" data-collapsible="accordion">
					<li ng-repeat="paragraph in content.paragraphs">
						<div class="collapsible-header">
							<h3>{{paragraph.title}}</h3>
						</div>
						<div class="collapsible-body white">
							<div class="editor white">
								{{paragraph.html}}
							</div>	
						</div>
					</li>
				</ul>
	<script src="https://cdn.quilljs.com/1.2.6/quill.js"></script>			
	<script>
		  var FontAttributor = Quill.import('attributors/class/font');
		FontAttributor.whitelist = [
		  'Roboto'
		];
		Quill.register(FontAttributor, true);

		  var quill = new Quill('.editor', {

		  theme: 'snow'
		  });
	</script>				
	<script>
$(document).ready(function(){
    $('.collapsible').collapsible();
  });
        

</script>