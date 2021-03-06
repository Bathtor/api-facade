var Roll20Extras = Roll20Extras || (function() {
    'use strict';
    const _version = '1.0.0',
        _generateUUID = function() {
            var a = 0,
                b = [];
            return function() {
                var c = (new Date()).getTime() + 0,
                    d = c === a;
                a = c;
                for (var e = new Array(8), f = 7; 0 <= f; f--) {
                    e[f] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(c % 64);
                    c = Math.floor(c / 64);
                }
                c = e.join("");
                if (d) {
                    for (f = 11; 0 <= f && 63 === b[f]; f--) {
                        b[f] = 0;
                    }
                    b[f]++;
                } else {
                    for (f = 0; 12 > f; f++) {
                        b[f] = Math.floor(64 * Math.random());
                    }
                }
                for (f = 0; 12 > f; f++) {
                    c += "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(b[f]);
                }
                return c;
            };
        }(),
        _generateRowID = function() {
            return _generateUUID().replace(/_/g, "Z");
        }
    return {
    	version: _version,
        generateRowID: _generateRowID
    };
}());
