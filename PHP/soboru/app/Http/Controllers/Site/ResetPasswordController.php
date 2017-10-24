<?php

namespace App\Http\Controllers\Site;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\ResetsPasswords;

class ResetPasswordController extends Controller
{
    use ResetsPasswords;

    protected $redirectTo = '/';
    
    public function __construct()
    {
        $this->middleware('guest');
    }

    public function index(Request $request, $token = null)
    {
        return view('site.passwords.reset')->with(
            ['token' => $token, 'email' => $request->email]
        );
    }
}
