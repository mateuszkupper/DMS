<c:url value="/login" var="loginUrl"/>
<!DOCTYPE html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->

<link href="https://fonts.googleapis.com/css?family=EB+Garamond"
	rel="stylesheet">
<!-- Include stylesheet -->
<link href="https://cdn.quilljs.com/1.2.6/quill.snow.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=EB+Garamond"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body class="grey lighten-5">

	<div class="container grey lighten-5">
		<div class="row">
			<div class="col s12 valign-wrapper">
				<dic class="container">
				<form action="${loginUrl}" method="post">
				<div class="card white darken-1 z-depth-3 col s12">
					<div class="card-content black-text">
						<span class="card-title">Login</span>
						<div class="row">
							<div class="input-field col s6 black-text">
								<input id="username" type="text" name="username" class="validate"> <label
									for="username">User Name</label>
							</div>
							<div class="input-field col s6 black-text">
								<input id="password" type="password" class="validate" name="password"> <label
									for="password">Password</label>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</div>
					</div>
					<div class="card-action black-text">
						<button class="waves-effect waves-light btn" type="submit">Login</button> 
						<button class="waves-effect waves-light btn">Forgot your password?</button>
					</div>
				</div>
				</form>
				</dic>
			</div>
		</div>
	</div>


	<!-- Include the Quill library -->
	<script src="https://cdn.quilljs.com/1.2.6/quill.js"></script>

	<!-- Initialize Quill editor -->
	<script>
  var FontAttributor = Quill.import('attributors/class/font');
FontAttributor.whitelist = [
  'Roboto'
];
Quill.register(FontAttributor, true);

var toolbarOptions = [
  ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
  ['blockquote', 'code-block'],

  [{ 'header': 1 }, { 'header': 2 }],               // custom button values
  [{ 'list': 'ordered'}, { 'list': 'bullet' }],
  [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
  [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
  [{ 'direction': 'rtl' }],                         // text direction

  [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
  [{ 'header': [1, 2, 3, 4, 5, 6, false] }],

  [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
  [{ 'font': ['Roboto'] }],
  [{ 'align': [] }],

  ['clean']                                         // remove formatting button
];

  var quill = new Quill('#editor', {

  theme: 'snow'
  });
  

</script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
</body>
</html>