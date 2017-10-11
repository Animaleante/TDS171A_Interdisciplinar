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
            'nasc' => Carbon::parse('01/01/2001'),
            'sexo_id' => 2,
            'notificacao_email' => 1,
        ]);

        User::create([
            'nome' => 'Usuário Admin',
            'login' => 'admin',
            'email' => 'admin@teste.com',
            'password' => bcrypt('123456'),
            'role_id' => 2,
            'nasc' => Carbon::parse('06/06/2006'),
            'sexo_id' => 2,
            'notificacao_email' => 0,
        ]);
    }
}
