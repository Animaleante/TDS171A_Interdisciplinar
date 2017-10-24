<?php

namespace App\Utils;

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Storage;
use TeVejo\Models\Show;

class Utils
{
    public static function formatDateDb($date)
    {
        return implode('-', array_reverse(explode('/', $date)));
    }

    public static function activeRouteClass($route)
    {

        if (is_array($route)) {
            foreach ($route as $r) {
                if (Route::is($r)) {
                    return 'active';
                }
            }

            return '';
        }

        return Route::is($route) ? 'active' : '';
    }
}