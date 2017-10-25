<?php

use Illuminate\Database\Seeder;
use App\Models\User;
use Carbon\Carbon;

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
            'nome' => 'Usuário Teste',
            'login' => 'teste',
            'email' => 'teste@teste.com',
            'password' => bcrypt('123456'),
            'role_id' => 1,
            'nasc' => '2001-01-02',
            'sexo_id' => 2,
            'notificacao_email' => 1,
        ]);

        User::create([
            'nome' => 'Usuário Admin',
            'login' => 'admin',
            'email' => 'admin@teste.com',
            'password' => bcrypt('123456'),
            'role_id' => 2,
            'nasc' => '2006-10-05',
            'sexo_id' => 2,
            'notificacao_email' => 0,
        ]);
    }
}
