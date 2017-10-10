<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>{{ config('app.name', 'Laravel') }} - Admin</title>

        <link href="http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,800" rel="stylesheet">
        <script src="https://use.fontawesome.com/e808bf9397.js"></script>
        <link rel="shortcut icon" href="images/favicon.ico" />

        @yield('styles')
    </head>
    <body>
        @yield('content')
        
        <script src="{{ asset('js/app.js') }}"></script>

        @yield('scripts')
    </body>
</html>