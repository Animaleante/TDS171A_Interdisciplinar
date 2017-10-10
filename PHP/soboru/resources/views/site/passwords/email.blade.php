@extends('layouts.site.master')

@section('content')
<main class="main" role="main">
    <div class="wrap clearfix">
        <div class="row">
            <section class="content center full-width">
                <div class="modal container">
                <h3>Reset Password</h3>

                    @if (session('status'))
                        <div class="alert alert-success">
                            {{ session('status') }}
                        </div>
                    @endif

                    @if ($errors->any())
                        <div class="alert alert-danger">
                            <ul>
                                @foreach ($errors->all() as $error)
                                    <li>{{ $error }}</li>
                                @endforeach
                            </ul>
                        </div>
                    @endif

                    <form class="form-horizontal" method="POST" action="{{ route('password.reset.email') }}">
                        {{ csrf_field() }}

                        {{-- <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                            <label for="email" class="col-md-4 control-label">E-Mail Address</label>

                            <div class="col-md-6">
                                <input id="email" type="email" class="form-control" name="email" value="{{ old('email') }}" required>

                                @if ($errors->has('email'))
                                    <span class="help-block">
                                        <strong>{{ $errors->first('email') }}</strong>
                                    </span>
                                @endif
                            </div>
                        </div> --}}

                        <div class="f-row">
                            <input id="email" type="text" name="email" placeholder="E-mail" value="{{ old('email') }}" required/>
                        </div>
                        
                        <div class="f-row bwrap">
                            <input type="submit" value="Send Password Reset Link" />
                        </div>
                    </form>

                </div>
            </section>
        </div>
    </div>
</main>
@endsection
