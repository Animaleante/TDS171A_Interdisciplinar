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

Auth::routes();

Route::group(['as' => 'site.'], function () {
    Route::get('', ['uses' => 'HomeController@index', 'as' => 'index']);

    // Auth::routes();

    Route::group(['prefix' => 'receitas', 'as' => 'receitas.'], function () {
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

    Route::get('suporte', ['uses' => 'SuporteController@index', 'as' => 'index']);
    Route::post('suporte', ['uses' => 'SuporteController@send', 'as' => 'send']);
});