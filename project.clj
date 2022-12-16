(defproject widgets "0.1.0-SNAPSHOT"
  :dependencies
  [[org.clojure/clojure "1.11.1"]
   [thheller/shadow-cljs "2.20.14"]

   [kee-frame "1.3.2" :exclusions [com.taoensso/encore io.aviso/pretty]]
   [com.taoensso/encore "3.45.0"]
   [io.aviso/pretty "1.3"]
   [org.slf4j/slf4j-nop "2.0.6"]]

  :source-paths
  ["src"]

  :test-paths
  ["test"]

  :profiles
  {:dev {:dependencies
         [[binaryage/devtools "1.0.6"]
          [day8.re-frame/re-frame-10x "1.5.0"]
          [day8.re-frame/tracing "0.6.2"]]

         :source-paths
         ["src" "dev"]

         :clean-targets
         ^{:protect false}
         ["resources/public/js/compiled" :target-path]}})
