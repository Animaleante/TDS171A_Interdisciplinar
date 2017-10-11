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

Route::group(['prefix' => 'admin', 'as' => 'admin.', 'middleware' => ['check_role:2']], function () {
    Auth::routes();

    Route::group(['namespace' => 'Admin', 'middleware' => 'auth'], function () {
        Route::get('', ['uses' => 'HomeController@index', 'as' => 'index']);

        Route::group(['prefix' => 'user', 'as' => 'user.'], function() {
            Route::get('', ['uses' => 'UserController@index', 'as' => 'index']);
            Route::get('create', ['uses' => 'UserController@create', 'as' => 'create']);
            Route::post('create', ['uses' => 'UserController@store', 'as' => 'store']);
            Route::get('{user}', ['uses' => 'UserController@show', 'as' => 'show']);

            Route::get('{user}/delete', ['uses' => 'UserController@destroy', 'as' => 'destroy']);
        });
    });
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

    Route::group(['prefix' => 'receitas', 'as' => 'receitas.', 'namespace' => 'Site'], function () {
        Route::get('', ['uses' => 'ReceitasController@index', 'as' => 'index']);
        Route::get('create', ['uses' => 'ReceitasController@create', 'as' => 'create']);
        Route::post('create', ['uses' => 'ReceitasController@store', 'as' => 'store']);
        Route::get('search', ['uses' => 'ReceitasController@search', 'as' => 'search']);
        Route::get('{receita}', ['uses' => 'ReceitasController@show', 'as' => 'show']);
        Route::get('{receita}/edit', ['uses' => 'ReceitasController@edit', 'as' => 'edit']);
        Route::post('{receita}/edit', ['uses' => 'ReceitasController@update', 'as' => 'update']);
        Route::get('{receita}/delete', ['uses' => 'ReceitasController@delete', 'as' => 'delete']);
        Route::post('{receita}/delete', ['uses' => 'ReceitasController@destroy', 'as' => 'destroy']);

        Route::post('{receita}/comments', ['uses' => 'ComentariosController@store', 'as' => 'store']);
    });

    Route::get('suporte', ['uses' => 'Site\SuporteController@index', 'as' => 'index']);
    Route::post('suporte', ['uses' => 'Site\SuporteController@send', 'as' => 'send']);
});