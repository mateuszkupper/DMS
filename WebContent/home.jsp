<html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=EB+Garamond"
	rel="stylesheet">
<!-- Include stylesheet -->
<link href="https://cdn.quilljs.com/1.2.6/quill.snow.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=EB+Garamond"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
          <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
          <script src="${pageContext.request.contextPath}/script/script.js"></script>     
</head>
<body>
	<div class="col s3 z-depth-3">

		<nav class="deep-orange darken-3">
			<div class="nav-wrapper white-text">
				<a href="#" class="brand-logo">Logo</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="sass.html">Home</a></li>
					<li><a href="badges.html">Admin</a></li>
					<li><a href="collapsible.html">User User</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col l2 m12" id="notif" ng-controller="notificationsForHomeController" ng-view>

			</div>
			<div class="col l8 m12 z-depth-3 deep-orange lighten-4 black-text" id="middle" ng-controller="mainSectionForHomeController" ng-app="mainSection" ng-view>


			</div>
			<div class="col l2 m12"><h2>Latest changes:</h2>
				          <div class="collection black-text">
        <a href="#!" class="collection-item black-text">Doc1 > Sec4 > Paragraph7</a>
        <a href="#!" class="collection-item black-text">Doc1 > Sec4 > Paragraph7</a>
        <a href="#!" class="collection-item black-text">Doc1 > Sec4 > Paragraph7</a>
        <a href="#!" class="collection-item black-text">Doc1 > Sec4 > Paragraph7</a>
      </div>
			</div>
			<div class="row"></div>
		</div>
		<footer class="page-footer deep-orange z-depth-2">
			<div class="container">
				<div class="row">
					<div class="col l6 s12">
						<h5 class="white-text">Footer Content</h5>
						<p class="white-text text-lighten-4">You can use rows and
							columns here to organize your footer content.</p>
					</div>
					<div class="col l4 offset-l2 s12">
						<h5 class="white-text">Links</h5>
						<ul>
							<li><a class="white-text text-lighten-3" href="#!">Link
									1</a></li>
							<li><a class="white-text text-lighten-3" href="#!">Link
									2</a></li>
							<li><a class="white-text text-lighten-3" href="#!">Link
									3</a></li>
							<li><a class="white-text text-lighten-3" href="#!">Link
									4</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="footer-copyright">
				<div class="container">
					© 2014 Copyright Text <a class="black-text text-lighten-4 right"
						href="#!">More Links</a>
				</div>
			</div>
		</footer>
	</div>


	<!-- Include the Quill library -->
	<script src="https://cdn.quilljs.com/1.2.6/quill.js"></script>

	<!-- Initialize Quill editor -->
	<script>
//   var FontAttributor = Quill.import('attributors/class/font');
// FontAttributor.whitelist = [
//   'Roboto'
// ];
// Quill.register(FontAttributor, true);

// var toolbarOptions = [
//   ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
//   ['blockquote', 'code-block'],

//   [{ 'header': 1 }, { 'header': 2 }],               // custom button values
//   [{ 'list': 'ordered'}, { 'list': 'bullet' }],
//   [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
//   [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
//   [{ 'direction': 'rtl' }],                         // text direction

//   [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
//   [{ 'header': [1, 2, 3, 4, 5, 6, false] }],

//   [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
//   [{ 'font': ['Roboto'] }],
//   [{ 'align': [] }],

//   ['clean']                                         // remove formatting button
// ];

//   var quill = new Quill('#editor', {

//   theme: 'snow'
//   });
  

</script>

</body>
</html>