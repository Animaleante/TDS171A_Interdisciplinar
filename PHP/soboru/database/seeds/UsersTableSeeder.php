<?php

use Illuminate\Database\Seeder;
use App\Models\User;

class UsersTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        User::create([
            'nome_usuario' => 'teste',
            'email' => 'teste@teste.com',
            'password' => bcrypt('123456'),
            'role_id' => \App\Models\Role::first()->id,
            'nasc' => \Carbon\Carbon::parse('01/01/1900'),
            'sexo_id' => 2,
            'notificacao_email' => 1,
        ]);
    }
}
