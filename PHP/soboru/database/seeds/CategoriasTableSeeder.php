<?php

use Illuminate\Database\Seeder;
use App\Models\Categoria;

class CategoriasTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Categoria::create([
            'nome_categoria'=>'CARNES',
            'selecionavel'=>0,
            'slug'=>'carnes'
        ]);

        Categoria::create([
            'nome_categoria'=>'Alcatra',
            'id_super_categoria'=>1,
            'selecionavel'=>1,
            'slug'=>'alcatra'
        ]);
        Categoria::create([
            'nome_categoria'=>'Picanha',
            'id_super_categoria'=>1,
            'selecionavel'=>1,
            'slug'=>'picanha'
        ]);

        Categoria::create([
        	'nome_categoria'=>'DOCES',
        	'selecionavel'=>0,
        	'slug'=>'doces'
        ]);

        Categoria::create([
        	'nome_categoria'=>'Tortas',
        	'id_super_categoria'=>4,
        	'selecionavel'=>1,
        	'slug'=>'tortas'
        ]);
        Categoria::create([
            'nome_categoria'=>'Bolos',
            'id_super_categoria'=>4,
            'selecionavel'=>1,
            'slug'=>'bolos'
        ]);
        Categoria::create([
        	'nome_categoria'=>'Chocolate',
        	'id_super_categoria'=>6,
        	'selecionavel'=>1,
        	'slug'=>'chocolate'
        ]);
    }
}
