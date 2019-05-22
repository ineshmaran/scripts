def command="/usr/bin/arsenal --quiet node_groups search name=f.[p]_(ade|bid)"
def proc = command.execute()
proc.waitFor()
def choices = proc.in.text.tokenize()
return choices.sort()

def ad_search_frp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh && alh | grep f[r]ps-ade' ].execute()
def ad_frp = ad_search_frp.text.tokenize()

def bid_search_frp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh && alh | grep f[r]ps-bid' ].execute()
def bid_frp = bid_search_frp.text.tokenize()

def ad_search_fxp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh && alh | grep f[x]ps-ade' ].execute()
def ad_fxp = ad_search_fxp.text.tokenize()

def bid_search_fxp = [ '/bin/sh', '-c', '. /etc/profile.d/script.sh && alh | grep f[x]ps-bid' ].execute()
def bid_fxp = bid_search_fxp.text.tokenize()

if (NODE_GROUP.equals("frp_ade")) {
   return ad_frp
}
else if (NODE_GROUP.equals("frp_bid")) {
   return bid_frp
}
else if (NODE_GROUP.equals("fxp_ade")) {
   return ad_fxp
}
else if (NODE_GROUP.equals("fxp_bid")) {
   return bid_fxp
}
else{
   return ["Unknown Server Type"]
}

env=ENV.take(1)
if (NODE_GROUP.contains("ade")) {
   def proc = ["sh", "-c", "echo version1_${ENV} version2_${ENV} version3_${ENV} version4_${ENV} version5_${ENV} version6_${ENV}"].execute()
   proc.waitFor()
   def clashboardVariables=proc.in.text.tokenize()
   if (clashboardVariables) {
      return clashboardVariables.sort()
}
}
else if (NODE_GROUP.contains("bid")) {
   def proc = ["sh", "-c", "echo version_${ENV}"].execute()
   proc.waitFor()
   def clashboardVariables=proc.in.text.tokenize()
   if (clashboardVariables) {
      return clashboardVariables.sort()
}
}
else{
   return ["Unknown Server Type"]
}
