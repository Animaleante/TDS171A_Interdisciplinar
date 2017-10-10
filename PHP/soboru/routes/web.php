<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

/*Route::get('/', function () {
    // return view('welcome');
    return view('index');
});*/

// Auth::routes();

Route::group(['prefix' => 'admin', 'as' => 'admin.'], function () {
    // Auth::routes();

    Route::get('', ['uses' => 'Admin\HomeController@index', 'as' => 'index']);
});

Route::group(['middleware' => 'guest'], function () {
    Route::get('forgot-password', ['uses' => 'Site\ForgotPasswordController@index', 'as' => 'password.request']);
    Route::post('forgot-password', ['uses' => 'Site\ResetPasswordController@reset', 'as' => 'password.request']);
    Route::get('forgot-password/{token}', ['uses' => 'Site\ResetPasswordController@index', 'as' => 'password.reset']);
    Route::post('forgot-password/send-link', ['uses' => 'Site\ForgotPasswordController@sendResetLinkEmail', 'as' => 'password.reset.email']);
});

Route::group(['as' => 'site.'], function () {
    Route::get('', ['uses' => 'Site\HomeController@index', 'as' => 'index']);

    Route::group(['middleware' => 'guest'], function () {
        Route::get('register', ['uses' => 'Site\RegisterController@index', 'as' => 'register.index']);
        Route::post('register', ['uses' => 'Site\RegisterController@register', 'as' => 'register.store']);
        Route::get('login', ['uses' => 'Site\LoginController@index', 'as' => 'login.index']);
        Route::post('login', ['uses' => 'Site\LoginController@login', 'as' => 'login.store']);
    });

    Route::group(['middleware' => 'auth_site'], function () {
        Route::get('logout', ['uses' => 'Site\LoginController@logout', 'as' => 'logout.index']);
    });

    // Auth::routes();

    Route::group(['prefix' => 'receitas', 'as' => 'receitas.'], function () {
        Route::get('', ['uses' => 'ReceitasController@index', 'as' => 'index']);
        Route::get('create', ['uses' => 'Site\ReceitasController@create', 'as' => 'create']);
        Route::post('create', ['uses' => 'Site\ReceitasController@store', 'as' => 'store']);
        Route::get('search', ['uses' => 'Site\ReceitasController@search', 'as' => 'search']);
        Route::get('{receita}', ['uses' => 'Site\ReceitasController@show', 'as' => 'show']);
        Route::get('{receita}/edit', ['uses' => 'Site\ReceitasController@edit', 'as' => 'edit']);
        Route::post('{receita}/edit', ['uses' => 'Site\ReceitasController@update', 'as' => 'update']);
        Route::get('{receita}/delete', ['uses' => 'Site\ReceitasController@delete', 'as' => 'delete']);
        Route::post('{receita}/delete', ['uses' => 'Site\ReceitasController@destroy', 'as' => 'destroy']);

        Route::post('{receita}/comments', ['uses' => 'Site\ComentariosController@store', 'as' => 'store']);
    });

    Route::get('suporte', ['uses' => 'Site\SuporteController@index', 'as' => 'index']);
    Route::post('suporte', ['uses' => 'Site\SuporteController@send', 'as' => 'send']);
});