require 'selenium-webdriver'

wbdrv = Selenium::WebDriver.for :firefox
wbdrv.manage.timeouts.implicit_wait = 10

links = File.open(ARGV[0]).read
products = File.new("#{Time.now.strftime("%Y%m%d%H%M%S")}_asda_products.txt", "w")

category = String.new
links.each_line do |ln|
  if ln =~ /^http:\/\/groceries.asda.com/
    begin
      wbdrv.get ln

      id = wbdrv.find_element(:css, 'div.prod-code h3 span').text
      weight = /\d+[glt]$/.match(wbdrv.find_element(:css, 'span.weight').text).to_s
      name = wbdrv.find_element(:css, 'h1.prod-title').text.strip + " " + weight.strip
      name.strip!
      item_price = wbdrv.find_element(:css, 'p.prod-price span.prod-price-inner').text
      price_per_std_unit = wbdrv.find_element(:css, 'p.prod-price span.prod-quantity').text
      price_per_std_unit.gsub!(/ per /, "/")
      price_per_std_unit.delete!("()")
      if price_per_std_unit =~ /^\d+[.\d+]*p/
        p = /^\d+/.match price_per_std_unit
        price_per_std_unit.gsub!(/\d+.\d+p/, "£0.#{p}")
      end

      # Nutri info
      table_rows = wbdrv.find_elements(:tag_name, "tr")
      calories = "null"
      protein = "null"
      carbohydrates = "null"
      sugars = "null"
      fat = "null"
      saturates = "null"
      fibre = "null"
      salt = "null"

      table_rows.each do |row|
        case row.text
        when /^\d+kcal\s*\d+kcal$/
          calories = row.text.split[0].strip.delete("kcal")
          calories = "null" if calories == ""

        when /^Energy.*\(\d+kcal\)/
          calories = /\d+kcal/.match(row.text).to_s.strip.delete("kcal")
          calories = "null" if calories == ""

        when /^Fat.*\d+g/
          fat = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          fat = "null" if fat == ""

        when /^Protein.*\d+g/
          protein = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          protein = "null" if protein == ""

        when /^Carbohydrate[s]*/
          carbohydrates = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          carbohydrates = "null" if carbohydrates == ""

        when /[Ss]ugar[s]*/
          sugars = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          sugars = "null" if sugars == ""

        when /[Ss]aturates/
          saturates = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          saturates = "null" if saturates == ""

        when /^Fibre/
          fibre = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          fibre = "null" if fibre == ""

        when /^Salt/
          salt = /\d+[.\d+]*g/.match(row.text).to_s.strip.delete("g")
          salt = "null" if salt == ""
        end
      end
      products.write "#{id};"\
                     "#{name};"\
                     "#{item_price};"\
                     "#{price_per_std_unit};"\
                     "#{category};"\
                     "#{calories};"\
                     "#{protein};"\
                     "#{carbohydrates};"\
                     "#{sugars};"\
                     "#{fat};"\
                     "#{saturates};"\
                     "#{fibre};"\
                     "#{salt};\n"
    rescue Selenium::WebDriver::Error::NoSuchElementError
      puts "Something went wrong. Couldn't scrape this: #{ln}"
    end
  else
    category = ln
  end
end

wbdrv.quit
