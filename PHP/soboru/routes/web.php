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

Route::get('/receitas', 'ReceitasController@index');
Route::get('/receitas/create', 'ReceitasController@create');
Route::post('/receitas/create', 'ReceitasController@store');
Route::get('/receitas/{receita}/show', 'ReceitasController@show');
Route::get('/receitas/{receita}/edit', 'ReceitasController@edit');
Route::post('/receitas/{receita}/edit', 'ReceitasController@update');
Route::get('/receitas/{receita}/delete', 'ReceitasController@delete');
Route::post('/receitas/{receita}/delete', 'ReceitasController@destroy');
