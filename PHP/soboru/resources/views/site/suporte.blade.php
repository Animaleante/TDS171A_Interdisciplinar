@extends('layouts.site.master')

@section('content')
    <main class="main" role="main">
        <div class="wrap clearfix">
            <div class="row">
                <section class="content center full-width">
                    <div class="modal container">
                        <form method="post" action="/suporte">
                            {{ csrf_field() }}

                            <h3>Suporte</h3>
                            <div id="message" class="alert alert-danger"></div>
                            <div class="f-row">
                                <input type="text" placeholder="Your name" id="name" />
                            </div>
                            <div class="f-row">
                                <input type="email" placeholder="Your email" id="email" />
                            </div>
                            <div class="f-row">
                                <input type="number" placeholder="Your phone number" id="phone" />
                            </div>
                            <div class="f-row">
                                <textarea placeholder="Your message" id="comments"></textarea>
                            </div>
                            <div class="f-row bwrap">
                                <input type="submit" value="Send message" />
                            </div>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </main>
@endsection