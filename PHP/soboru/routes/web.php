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

Route::get('/', function () {
    // return view('welcome');
    return view('index');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::get('/receita', 'ReceitasController@index');
Route::get('/receita/create', 'ReceitasController@create');
Route::post('/receita/create', 'ReceitasController@store');
Route::get('/receita/{receita}/show', 'ReceitasController@show');
Route::get('/receita/{receita}/edit', 'ReceitasController@edit');
Route::post('/receita/{receita}/edit', 'ReceitasController@update');
Route::get('/receita/{receita}/delete', 'ReceitasController@delete');
Route::post('/receita/{receita}/delete', 'ReceitasController@destroy');
