(let [plugins #{"clojure" "haskell" "fun-prog-links" "help"}]
  {:servers ["irc.cc.tut.fi"]        ; A list of servers.
   :prepends #{"@"}   ; The character you want for a prepend. Currently set to @
   :max-operations 3
   :pending-ops 0
   :prefix-arrow "\u21D2 "
   :clojure {:eval-prefixes {:defaults ["." ","]}}
   :servers-port 8080                  ; port for plugins that require a webserver
   "irc.cc.tut.fi" {:channels ["#deraen1"]
                    :bot-name "DeraenBot"
                    :bot-password nil
                    :users {"Deraen" {:pass "123", :privs :admin}}
                    :plugins plugins}})
