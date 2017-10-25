<?php

use Illuminate\Database\Seeder;
use App\Models\Medida;

class MedidasTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Medida::create([
            'nome' => 'grama(s)',
            'abreviacao' => 'g'
        ]);
        Medida::create([
            'nome'=> 'kilograma(s)',
            'abreviacao' => 'kg'
        ]);
        Medida::create([
            'nome'=> 'colher(es) de chá',
            'abreviacao' => 'colher(es) de chá'
        ]);
        Medida::create([
            'nome'=> 'xícara(s)',
            'abreviacao' => 'xícara(s)'
        ]);
    }
}
