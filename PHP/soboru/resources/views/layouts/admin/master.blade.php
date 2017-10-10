<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>{{ config('app.name', 'Laravel') }} - Admin</title>

        <link rel="shortcut icon" href="images/favicon.ico" />

        <link rel="stylesheet" href="{{ asset('css/admin/bootstrap.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/font-awesome.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/ionicons.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/AdminLTE.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/admin/skin-red.min.css') }}">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

        @yield('styles')
    </head>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            @include('layouts.admin.header')
            @include('layouts.admin.left-sidebar')
            @yield('content')
            @include('layouts.admin.footer')
        </div>
        
        <script src="{{ asset('js/admin/jquery.min.js') }}"></script>
        <script src="{{ asset('js/admin/bootstrap.min.js') }}"></script>
        <script src="{{ asset('js/admin/jquery.slimscroll.min.js') }}"></script>
        <script src="{{ asset('js/admin/fastclick.js') }}"></script>
        <script src="{{ asset('js/admin/adminlte.min.js') }}"></script>

        <script>
            $(document).ready(function () {
                $('.sidebar-menu').tree()
            })
        </script>

        @yield('scripts')
    </body>
</html>