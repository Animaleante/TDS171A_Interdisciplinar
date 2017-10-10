<?php

namespace App\Http\Controllers\Site;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class SuporteController extends Controller
{
    public function index() {
        return view('site.suporte');
    }

    public function send() {
        dd(request()->all());
    }
}
