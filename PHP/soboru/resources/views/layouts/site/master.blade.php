<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        {{-- <meta name="keywords" content="SocialChef - Social Recipe HTML Template" /> --}}
        {{-- <meta name="description" content="SocialChef - Social Recipe HTML Template"> --}}
        {{-- <meta name="author" content="themeenergy.com"> --}}
        
        <title>{{ config('app.name', 'Laravel') }}</title>
        
        <link href="{{ asset('css/site.css') }}" rel="stylesheet">
        <link href="{{ asset('css/icons.css') }}" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Raleway:400,300,500,600,700,800" rel="stylesheet">
        <script src="https://use.fontawesome.com/e808bf9397.js"></script>
        <link rel="shortcut icon" href="images/favicon.ico" />

        @yield('styles')
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
    {{-- <body class="{{Route::is('home') ? 'home' : ''}}"> --}}
    {{-- <body class="{{Route::is('site.index') ? 'home' : ''}}"> --}}
        <!--preloader-->
        <div class="preloader">
            <div class="spinner"></div>
        </div>
        <!--//preloader-->
        
        @include('layouts.site.nav')
        
        @yield('content')

        @include('layouts.site.footer')
        
        <script src="{{ asset('js/app.js') }}"></script>
        <script src="{{ asset('js/bootstrap3-typeahead.min.js') }}"></script>
        <script src="{{ asset('js/jquery.uniform.min.js') }}"></script>
        <script src="{{ asset('js/jquery.slicknav.min.js') }}"></script>
        <script src="{{ asset('js/scripts.js') }}"></script>

        @yield('scripts')
    </body>
</html>


