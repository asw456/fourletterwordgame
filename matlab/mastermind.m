% MASTERMIND

function guesses = mastermind(dictionary_name)
    
    % READ DICTIONARY
    
    dictionary_full = read_words(dictionary_name);
    
    % CHOOSE TRUE WORD
    
    number_words = length(dictionary_full);
    number_letters = length(dictionary_full{1});
    real_word = dictionary_full{ceil(rand*number_words)};
    
    % CLEVER CODE
    
    dictionary_poss = dictionary_full;
    letter_frequencies = count_letters(dictionary_poss);
    guess_word = sample_word(dictionary_poss,letter_frequencies);
    
    guesses = 0;
    
    for i = 1 : number_words
        
        guesses = guesses + 1;
        
        c = match_words(guess_word,real_word);
        
        if c == number_letters
            
            if strcmp(guess_word,real_word)
                
                return
                
            else
                
                dictionary_poss = trim_dictionary(dictionary_poss,guess_word,number_letters);
                dictionary_poss = dictionary_poss(~ismember(dictionary_poss,guess_word));
                number_poss = length(dictionary_poss);
                
                for i = 1 : number_poss
                    
                    guess_word = dictionary_poss{i};
                    
                    guesses = guesses + 1;
                    
                    if strcmp(guess_word,real_word)
                        
                        return
                        
                    end
                    
                end
                
            end
            
        end
        
        dictionary_poss = trim_dictionary(dictionary_poss,guess_word,c);
        letter_frequencies = count_letters(dictionary_poss);
        guess_word = sample_word(dictionary_poss,letter_frequencies);
        
    end
    
end

%% FULL DICTIONARY METHODS

function number_words = count_words(dictionary_name)
    
    fileID = fopen(dictionary_name);
    
    while ~feof(fileID)
        
        line = fgetl(fileID);
        
        if isempty(line)
            
            line = fgetl(fileID);
            
            number_words = str2double(line);
            break
            
        end
        
    end
    
    fclose(fileID);
    
end

function dictionary_full = read_words(dictionary_name)
    
    number_words = count_words(dictionary_name);
    
    dictionary_full = cell(number_words,1);
    
    fileID = fopen(dictionary_name);
    
    for i = 1 : number_words
        
        word = fgetl(fileID);
        
        dictionary_full{i} = word;
        
    end
    
    fclose(fileID);
    
end

%% POSS DICTIONARY METHODS

function letter_frequencies = count_letters(dictionary_poss)
    
    letter_frequencies = containers.Map('keytype','char','valuetype','double');
    
    number_words = length(dictionary_poss);
    number_letters = length(dictionary_poss{1});
    
    for i = 1 : number_words
        
        for j = 1 : number_letters
            
            letter = dictionary_poss{i}(j);
            
            if isKey(letter_frequencies,letter)
                
                letter_frequencies(letter) = letter_frequencies(letter) + 1;
                
            else
                
                letter_frequencies(letter) = 1;
                
            end
            
        end
        
    end
    
    letters = keys(letter_frequencies);
    
    for k = 1 : length(letters)
        
        letter = letters{k};
        
        letter_frequencies(letter) = letter_frequencies(letter)/(number_words*number_letters);
        
    end
    
end

function dictionary_new = trim_dictionary(dictionary_old,guess_word,c)
    
    number_words = length(dictionary_old);
    
    dictionary_new = cell(number_words,1);
    
    w = 0;
    
    for i = 1 : number_words
        
        if match_words(guess_word,dictionary_old{i}) == c
            
            w = w + 1;
            
            dictionary_new{w,1} = dictionary_old{i,1};
            
        end
        
    end
    
    dictionary_new = dictionary_new(1:w);
    
end

%% ACTION METHODS

function c = match_words(guess_word,true_word)
    
    number_letters = length(true_word);
    
    c = 0;
    
    for i = 1 : number_letters
        
        for j = 1 : number_letters - c
            
            if guess_word(i) == true_word(j)
                
                true_word = true_word([1:j-1,j+1:number_letters - c]);
                
                c = c + 1;
                break
                
            end
            
        end
        
    end
    
end

function letter = sample_letter(letter_frequencies)
    
    letters = keys(letter_frequencies);
    frequencies = values(letter_frequencies);
    
    index = rand;
    
    for i = 1 : length(letter_frequencies)
        
        if sumabs(frequencies(1:i)) > index
            
            letter = letters{i};
            break
            
        end
        
    end
    
end

function guess_word = sample_word(dictionary_poss,letter_frequencies)
    
    number_words = length(dictionary_poss);
    number_letters = length(dictionary_poss{1});
    
    M = 10000;
    
    for i = 1 : M
        
        letters = char();
        matches = cell(number_words,1);
        
        for j = 1 : number_letters
            
            letters(j) = sample_letter(letter_frequencies);
            
        end
        
        m = 0;
        
        for j = 1 : number_words
            
            if match_words(letters,dictionary_poss{j}) == number_letters
                
                m = m + 1;
                
                matches{m,1} = dictionary_poss{j};
                
            end
            
        end
        
        matches = matches(1:m);
        
        if ~isempty(matches)
            
            break
            
        end
        
    end
    
    if i == M
        
        guess_word = dictionary_poss{ceil(rand*number_words)};
        return
        
    else
        
        number_matches = length(matches);
        guess_word = matches{ceil(rand*number_matches)};
        
    end
    
end